package example.security.browser.authentication.remember.me;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import example.security.core.properties.SecurityProperties;
import example.security.dao.entity.BrowserRememberMe;
import example.security.thirdservice.services.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by wangww on 2018/12/1.
 */
@Component("browserPersistentTokenRepository")
public class BrowserPersistentTokenRepository implements PersistentTokenRepository {
    private static final Logger logger = LoggerFactory.getLogger(BrowserPersistentTokenRepository.class);

    @Autowired
    private SecurityService securityService;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void createNewToken(PersistentRememberMeToken persistentRememberMeToken) {
        List<BrowserRememberMe> browserRememberMes = securityService.getLocalAllByUsername(persistentRememberMeToken.getUsername());

        if (ObjectUtil.isNotNull(browserRememberMes) && browserRememberMes.size() >=  securityProperties.getBrowser().getLoginPoints()){
            int end = browserRememberMes.size() - securityProperties.getBrowser().getLoginPoints();
            for (int i=0;i<end;i++){
                securityService.removeUserToken(browserRememberMes.get(i).getUsername());
            }
        }

        BrowserRememberMe browserRememberMe = new BrowserRememberMe();
        BeanUtil.copyProperties(persistentRememberMeToken,browserRememberMe);
        browserRememberMe.setToken(persistentRememberMeToken.getTokenValue());
        browserRememberMe.setLastUserTime(persistentRememberMeToken.getDate());
        securityService.createNewToken(browserRememberMe);
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        BrowserRememberMe browserRememberMe = securityService.getTokenForSeries(series);
        if (ObjectUtil.isNotNull(browserRememberMe)){
            browserRememberMe.setToken(tokenValue);
            browserRememberMe.setLastUserTime(lastUsed);
            securityService.updateToken(series,tokenValue,lastUsed);
        }
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {

        BrowserRememberMe browserRememberMe = securityService.getTokenForSeries(seriesId);
        if (ObjectUtil.isNotNull(browserRememberMe)){
            PersistentRememberMeToken persistentRememberMeToken = new PersistentRememberMeToken(
                    browserRememberMe.getUsername(),browserRememberMe.getSeries(),
                    browserRememberMe.getToken(),browserRememberMe.getLastUserTime());
            return persistentRememberMeToken;
        }

        return null;
    }

    @Override
    public void removeUserTokens(String username) {
        securityService.removeUserToken(username);
    }
}
