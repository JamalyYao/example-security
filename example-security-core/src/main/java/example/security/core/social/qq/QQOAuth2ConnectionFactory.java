package example.security.core.social.qq;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

public class QQOAuth2ConnectionFactory extends OAuth2ConnectionFactory<QQService> {

    public QQOAuth2ConnectionFactory(String providerId, String appId,String appSecret) {
        super(providerId, new QQServiceProvider(appId,appSecret), new QQApiAdater());
    }
}
