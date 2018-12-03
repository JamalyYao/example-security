package example.security.core.social.qq;

import cn.hutool.core.util.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/***
 * 该类主要适配业务系统和第三方系统数据适配
 */
public class QQApiAdater implements ApiAdapter<QQService> {
    private static final Logger logger = LoggerFactory.getLogger(QQApiAdater.class);

    @Override
    public boolean test(QQService api) {
        return true;
    }

    @Override
    public void setConnectionValues(QQService api, ConnectionValues values) {
        QQUserInfo qqUserInfo = api.getRemoteQQData();
        if (ObjectUtil.isNotNull(qqUserInfo)){
            values.setDisplayName(qqUserInfo.getNickname());
            values.setProviderUserId(qqUserInfo.getOpenId());
            values.setImageUrl(qqUserInfo.getFigureurl_qq_1());
            values.setProfileUrl(null);
        }

    }

    @Override
    public UserProfile fetchUserProfile(QQService api) {
        return null;
    }

    @Override
    public void updateStatus(QQService api, String message) {

    }
}
