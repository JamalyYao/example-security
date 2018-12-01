package example.security.core.validator.code.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DefaultSmsCodeSender implements SmsCodeSender{
    private static final Logger logger = LoggerFactory.getLogger(DefaultSmsCodeSender.class);

    @Override
    public void send(String mobile, String code) throws Exception {
        logger.info("向手机"+mobile+"发送短信验证码"+code);
    }
}
