package example.security.core.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "example.security")
public class SecurityProperties {

    BrowserProperties browser = new BrowserProperties();

    ValidatorCodeProperties code = new ValidatorCodeProperties();

}
