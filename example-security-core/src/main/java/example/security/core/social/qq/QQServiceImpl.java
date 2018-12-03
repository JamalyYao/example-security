package example.security.core.social.qq;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

@Getter
@Setter
public class QQServiceImpl extends AbstractOAuth2ApiBinding implements QQService {

    private static final String GET_USER_INFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    private ObjectMapper objectMapper = new ObjectMapper();

    private String openId;

    private String appId;

    public QQServiceImpl(String accessToken,String appId){
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;

        String url = String.format(URL_GET_OPENID,accessToken);
        String result = this.getRestTemplate().getForObject(url,String.class);
        this.openId = StringUtils.substringBetween(result, "\"openid\":\"", "\"}");
    }

    @Override
    public QQUserInfo getRemoteQQData() {
        String getUserInfoUrl = String.format(GET_USER_INFO,appId,openId);
        String result = this.getRestTemplate().getForObject(getUserInfoUrl,String.class);

        QQUserInfo qqUserInfo = null;
        try {
            qqUserInfo = objectMapper.readValue(result,QQUserInfo.class);
            qqUserInfo.setOpenId(openId);
            return qqUserInfo;
        }catch (Exception ex){
            throw new RuntimeException("获取用户信息失败", ex);
        }
    }
}
