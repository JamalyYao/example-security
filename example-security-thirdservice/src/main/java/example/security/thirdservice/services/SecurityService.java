package example.security.thirdservice.services;

import example.security.dao.entity.BrowserPermission;
import example.security.dao.entity.BrowserUser;
import example.security.dao.specificdao.BrowserPermissionDao;
import example.security.dao.specificdao.BrowserUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityService {

    @Autowired
    private BrowserPermissionDao browserPermissionDao;

    @Autowired
    private BrowserUserDao browserUserDao;

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
}
