package example.security.core.validator.code.sms;

public interface SmsCodeSender {

    /***
     * 短信发送
     * @param mobile
     * @param code
     * @throws Exception
     */
    void send(String mobile, String code) throws Exception;
}
