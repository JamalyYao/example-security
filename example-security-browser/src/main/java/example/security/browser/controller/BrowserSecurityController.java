package example.security.browser.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import example.security.core.constants.SecurityBrowserConstant;
import example.security.core.properties.SecurityProperties;
import example.security.core.support.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class BrowserSecurityController {

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    @RequestMapping(SecurityBrowserConstant.DEFAULT_UNAUTHENTICATION_URL)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        SavedRequest savedRequest = requestCache.getRequest(httpServletRequest,httpServletResponse);//通过请求参数获取saveRequest对象
        if (ObjectUtil.isNotNull(savedRequest)){
            String targetUrl = savedRequest.getRedirectUrl();
            if (StrUtil.isNotEmpty(targetUrl) && StrUtil.endWithIgnoreCase(targetUrl,".html")){
                redirectStrategy.sendRedirect(httpServletRequest,httpServletResponse,securityProperties.getBrowser().getLoginPage());//可以自定义登录页面
            }
        }
        return new SimpleResponse("访问的服务需要身份认证，请引导用户到登录页面");
    }
}
