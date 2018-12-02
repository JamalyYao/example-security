package example.security.service.controller;

import example.security.dao.entity.BrowserUser;
import example.security.thirdservice.services.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private SecurityService securityService;

    @GetMapping("/me")
    @PreAuthorize("hasAnyAuthority({'sys:user:list'})")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails user) {
        logger.info("test security permission...........");
        logger.info("test security permission...........");
        logger.info("test security permission...........");
        logger.info("test security permission...........");
        return user;
    }

    @PostMapping("/regist")
    public void regist(BrowserUser user, HttpServletRequest request) {
        BrowserUser browserUser = new BrowserUser();
        browserUser.setAccount("wangww@163.com");
        browserUser.setCreateBy("wangww");
        browserUser.setEmail("wangww@163.com");
        browserUser.setLastLoginIp("127.0.0.1");
        browserUser.setMobileNo("15251005148");
        browserUser.setPassword("123456");
        browserUser.setPhoto("http://www.photo.com");
        browserUser.setSex("0");
        browserUser.setUserName("阿凡达");
        browserUser.setUserNickname("盖世英雄");
        browserUser.setUpdateBy("wangww");
        securityService.saveSelective(browserUser);
    }

}
