package example.security.core.validator.code.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import example.security.core.constants.SecurityBrowserConstant;
import example.security.core.properties.SecurityProperties;
import example.security.core.support.CustomRedisUtils;
import example.security.core.validator.code.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

public abstract class AbstractValidatorCodeProcessor<c extends ValidatorCode> implements ValidatorCodeProcessor {
    private static final Logger logger = LoggerFactory.getLogger(AbstractValidatorCodeProcessor.class);

    @Autowired
    private CustomRedisUtils customRedisUtils;

    @Autowired
    private Map<String,ValidatorCodeGenerator> validatorCodeGenerators;

    @Override
    public void create(ServletWebRequest request) throws Exception{
        //生成验证码信息
        c validatorCode = generate(request);
        //保存验证码信息
        save(request,validatorCode);
        //发送验证码信息
        send(request,validatorCode);
    }

    protected abstract void send(ServletWebRequest request, c validatorCode) throws Exception;

    /***
     * 保存验证码信息
     * @param validatorCode
     */
    private void save(ServletWebRequest request,c validatorCode) {
        String key = getSessionKey(request)+validatorCode.getCode();
        customRedisUtils.setNx(key,validatorCode.getCode(),validatorCode.getExpireIn());
    }

    private String getSessionKey(ServletWebRequest request) {
        return SecurityBrowserConstant.SESSION_KEY_PREFIX + getValidateCodeType(request).toString().toUpperCase();
    }

    /***
     * 生成验证码信息
     * @param request
     * @return
     */
    private c generate(ServletWebRequest request) {
        String type = getValidateCodeType(request).toString().toLowerCase();
        String generatorName = type + ValidatorCodeGenerator.class.getSimpleName();
        ValidatorCodeGenerator validatorCodeGenerator = validatorCodeGenerators.get(generatorName);
        if (ObjectUtil.isNull(validatorCodeGenerator)) {
            throw new ValidateCodeException("验证码生成器" + generatorName + "不存在");
        }
        return (c)validatorCodeGenerator.generator(request);
    }

    private ValidatorCodeType getValidateCodeType(ServletWebRequest request) {
        String type = StringUtils.substringBefore(this.getClass().getSimpleName(),"CodeProcessor");
        return ValidatorCodeType.valueOf(type.toUpperCase());
    }

    @Override
    public void validate(ServletWebRequest request) {
        ValidatorCodeType validatorCodeType = getValidateCodeType(request);

        String codeInRequest;
        try {
            codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(),validatorCodeType.getParamNameOnValidate());
        }catch (ServletRequestBindingException e){
            throw new ValidateCodeException("获取验证码的值失败");
        }

        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException(validatorCodeType + "验证码的值不能为空");
        }

        String key =  this.getSessionKey(request)+codeInRequest;
        String value = (String)customRedisUtils.get(key);

        if (StrUtil.isEmpty(value)){
            throw new ValidateCodeException(codeInRequest + "验证码已过期");
        }

        customRedisUtils.del(key);//校验完进行删除
    }
}
