package example.security.core.authentication;

import example.security.core.constants.SecurityBrowserConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationFailureHandler browserAuthenticationFailureHandler;

    @Autowired
    private AuthenticationSuccessHandler browserAuthenticationSuccessHandler;

    public void applyPasswordAuthenticationConfig(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .formLogin()
                .loginPage(SecurityBrowserConstant.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityBrowserConstant.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(browserAuthenticationSuccessHandler)
                .failureHandler(browserAuthenticationFailureHandler);
    }
}
