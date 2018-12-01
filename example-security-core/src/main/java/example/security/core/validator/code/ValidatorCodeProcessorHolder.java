package example.security.core.validator.code;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ValidatorCodeProcessorHolder {

    @Autowired
    private Map<String,ValidatorCodeProcessor> validatorCodeProcessors;

    public ValidatorCodeProcessor findValidatorCodeProcessor(String type) {
        String componentName = type.toLowerCase()+ValidatorCodeProcessor.class.getSimpleName();
        ValidatorCodeProcessor validatorCodeProcessor = validatorCodeProcessors.get(componentName);
        if (ObjectUtil.isNull(validatorCodeProcessor)){
            throw new ValidateCodeException("验证码处理器" + componentName + "不存在");
        }
        return validatorCodeProcessor;
    }

    public ValidatorCodeProcessor findValidatorCodeProcessor(ValidatorCodeType validatorCodeType) {
        return findValidatorCodeProcessor(validatorCodeType.toString());
    }
}
