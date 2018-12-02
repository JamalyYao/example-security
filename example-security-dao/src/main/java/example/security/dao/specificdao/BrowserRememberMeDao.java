package example.security.dao.specificdao;

import example.security.dao.entity.BrowserRememberMe;
import example.security.dao.mapper.BrowserRememberMeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * Created by wangww on 2018/12/1.
 */
@Repository
public class BrowserRememberMeDao extends BaseDao<BrowserRememberMe> {

    @Autowired
    private BrowserRememberMeMapper browserRememberMeMapper;


    @Override
    protected Mapper<BrowserRememberMe> getMapper() {
        return browserRememberMeMapper;
    }

    public void updateToken(String series, String tokenValue, Date lastUsed) {

        Example example = new Example(BrowserRememberMe.class);
        example.createCriteria().andEqualTo("series",series);

        BrowserRememberMe browserRememberMe = new BrowserRememberMe();
        browserRememberMe.setToken(tokenValue);
        browserRememberMe.setLastUserTime(lastUsed);

        this.updateByExampleSelective(browserRememberMe,example);
    }


    public void removeUserToken(String username) {

        BrowserRememberMe browserRememberMe = new BrowserRememberMe();
        browserRememberMe.setUsername(username);

        this.deleteByWhere(browserRememberMe);
    }

    public BrowserRememberMe getTokenForSeries(String seriesId) {
        Example example = new Example(BrowserRememberMe.class);
        example.createCriteria().andEqualTo("series",seriesId);

        return this.queryOne(example);
    }

    public List<BrowserRememberMe> getLocalAllByUsername(String username) {
        Example example = new Example(BrowserRememberMe.class);
        example.createCriteria().andEqualTo("username",username);

        return this.query(example);
    }
}
