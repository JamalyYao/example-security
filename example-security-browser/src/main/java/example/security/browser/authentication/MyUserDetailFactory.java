package example.security.browser.authentication;

import cn.hutool.core.util.StrUtil;
import example.security.browser.model.BrowserGrantedAuthority;
import example.security.browser.model.BrowserUserDetails;
import example.security.dao.entity.BrowserPermission;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetailFactory {

    /***
     * 构建userDetail用户对象
     * @param userName
     * @param password
     * @param browserPermissions
     * @return
     */
    public static BrowserUserDetails buildUserDetails(String userName,String password,List<BrowserPermission> browserPermissions){
        BrowserUserDetails browserUserDetails = new BrowserUserDetails(
                userName,
                password,
                mapToGrantedAuthorities(browserPermissions));
        return browserUserDetails;
    }

    /***
     * 集合转换成spring-security框架权限集合
     * @param browserPermissions
     * @return
     */
    private static Collection<? extends GrantedAuthority> mapToGrantedAuthorities(List<BrowserPermission> browserPermissions) {
        final List<BrowserGrantedAuthority> list = new ArrayList<>();
        for (BrowserPermission browserPermission : browserPermissions){
            if (StrUtil.isNotEmpty(browserPermission.getPermission()) && browserPermission.getPermission().indexOf(",") >= 0){
                String[] permissionValue = browserPermission.getPermission().split(",");
                for (String singlePermission : permissionValue){
                    list.add(new BrowserGrantedAuthority(browserPermission.getUrl(),browserPermission.getMethod(),singlePermission));
                }
            }else {
                list.add(new BrowserGrantedAuthority(browserPermission.getUrl(),browserPermission.getMethod(),browserPermission.getPermission()));
            }
        }

        return list;
    }
}
