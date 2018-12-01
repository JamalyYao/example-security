package example.security.core.validator.code.sms;

import example.security.core.constants.SecurityBrowserConstant;
import example.security.core.validator.code.ValidatorCode;
import example.security.core.validator.code.impl.AbstractValidatorCodeProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

@Component(value = "smsValidatorCodeProcessor")
public class SmsCodeProcessor extends AbstractValidatorCodeProcessor<ValidatorCode> {
    private static final Logger logger = LoggerFactory.getLogger(SmsCodeProcessor.class);

    @Autowired
    private SmsCodeSender smsCodeSender;

    @Override
    protected void send(ServletWebRequest request, ValidatorCode validatorCode) throws Exception {
        String paramName = SecurityBrowserConstant.DEFAULT_PARAMETER_NAME_MOBILE;
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
        smsCodeSender.send(mobile, validatorCode.getCode());
    }
}
