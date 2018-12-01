package example.security.core.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidatorCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    private SmsCodeProperties sms = new SmsCodeProperties();

}
