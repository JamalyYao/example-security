package example.security.browser.configuration;

import example.security.browser.authentication.access.denied.BrowserAccessDeniedHandlerImpl;
import example.security.core.authentication.AbstractChannelSecurityConfig;
import example.security.core.authentication.mobile.SmsAuthenticationSecurityConfig;
import example.security.core.constants.SecurityBrowserConstant;
import example.security.core.properties.SecurityProperties;
import example.security.core.validator.code.ValidatorCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) //开启全局方法权限设置
@ComponentScan(basePackages = {"example.security.browser"})
public class SecurityBrowserConfig extends AbstractChannelSecurityConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private BrowserAccessDeniedHandlerImpl browserAccessDeniedHandler;

    @Autowired
    private ValidatorCodeSecurityConfig validatorCodeSecurityConfig;

    @Autowired
    private SmsAuthenticationSecurityConfig smsAuthenticationSecurityConfig;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //设置表单登录形式
        applyPasswordAuthenticationConfig(httpSecurity);

        httpSecurity
                .apply(validatorCodeSecurityConfig)
                .and()
                .apply(smsAuthenticationSecurityConfig)
                .and()
                .exceptionHandling().accessDeniedHandler(browserAccessDeniedHandler)
                .and()
                .authorizeRequests()
                .antMatchers(
                        SecurityBrowserConstant.DEFAULT_UNAUTHENTICATION_URL,
                        securityProperties.getBrowser().getLoginPage(),
                        SecurityBrowserConstant.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();//关闭csrf跨站访问

        httpSecurity.headers().cacheControl();//禁用header缓存
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
