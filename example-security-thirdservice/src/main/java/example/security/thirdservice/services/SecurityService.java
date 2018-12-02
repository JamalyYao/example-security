package example.security.thirdservice.services;

import example.security.dao.entity.BrowserPermission;
import example.security.dao.entity.BrowserRememberMe;
import example.security.dao.entity.BrowserUser;
import example.security.dao.specificdao.BrowserPermissionDao;
import example.security.dao.specificdao.BrowserRememberMeDao;
import example.security.dao.specificdao.BrowserUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class SecurityService {

    @Autowired
    private BrowserPermissionDao browserPermissionDao;

    @Autowired
    private BrowserUserDao browserUserDao;

    @Autowired
    private BrowserRememberMeDao browserRememberMeDao;

    /***
     * 通过登录名获取用户权限
     * @param loginName
     * @return
     */
    public List<BrowserPermission> getPermissonByLoginName(String loginName){
        return browserPermissionDao.getPermissonByLoginName(loginName);
    }

    /***
     * 获取用户信息
     * @param account
     * @return
     */
    public BrowserUser getBrowserUserInfo(String account,String mobileNo) {
        return browserUserDao.getBrowserUserInfo(account,mobileNo);
    }

    /***
     * 用户添加
     * @param browserUser
     */
    public void saveSelective(BrowserUser browserUser) {
        browserUserDao.saveSelective(browserUser);
    }

    /***
     * 创建新的TOKEN
     * @param browserRememberMe
     */
    public void createNewToken(BrowserRememberMe browserRememberMe) {
        browserRememberMeDao.saveSelective(browserRememberMe);
    }

    /***
     * 更新TOKEN
     * @param series
     * @param tokenValue
     * @param lastUsed
     */
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        browserRememberMeDao.updateToken(series,tokenValue,lastUsed);
    }

    /***
     * 清空用户TOKEN
     * @param username
     */
    public void removeUserToken(String username) {
        browserRememberMeDao.removeUserToken(username);
    }

    /***
     * 获取用户记住相关信息
     * @param seriesId
     * @return
     */
    public BrowserRememberMe getTokenForSeries(String seriesId) {
        return browserRememberMeDao.getTokenForSeries(seriesId);
    }

    public List<BrowserRememberMe> getLocalAllByUsername(String username) {
        return browserRememberMeDao.getLocalAllByUsername(username);
    }
}
