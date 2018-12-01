package example.security.browser.authentication;

import cn.hutool.core.util.ObjectUtil;
import example.security.dao.entity.BrowserPermission;
import example.security.dao.entity.BrowserUser;
import example.security.thirdservice.services.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "myUserDetailService")
public class BrowserUserDetailService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(BrowserUserDetailService.class);

    @Autowired
    private SecurityService securityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BrowserUser browserUser = securityService.getBrowserUserInfo(username,"");

        if (ObjectUtil.isNull(browserUser)){
            browserUser = securityService.getBrowserUserInfo("",username);
            if (ObjectUtil.isNull(browserUser)){
                throw new UsernameNotFoundException(username);
            }
        }

        List<BrowserPermission> browserPermissions = securityService.getPermissonByLoginName(username);

        return MyUserDetailFactory.buildUserDetails(browserUser.getAccount(),passwordEncoder.encode(browserUser.getPassword()),browserPermissions);
    }
}
