package example.security.core.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QQProperties {

    private String appId;

    private String appSecret;

    private String providerId = "qq";
}
