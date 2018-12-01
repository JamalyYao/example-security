package example.security.core.validator.code.sms;

import cn.hutool.core.util.RandomUtil;
import example.security.core.properties.SecurityProperties;
import example.security.core.validator.code.ValidatorCode;
import example.security.core.validator.code.ValidatorCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

@Component("smsValidatorCodeGenerator")
public class SmsCodeGenerator implements ValidatorCodeGenerator{

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidatorCode generator(ServletWebRequest request) {
        String code = RandomUtil.randomNumbers(securityProperties.getCode().getSms().getLength());
        return new ValidatorCode(code,securityProperties.getCode().getSms().getExpireIn());
    }
}
