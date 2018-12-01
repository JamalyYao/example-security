package example.security.core.validator.code;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import example.security.core.constants.SecurityBrowserConstant;
import example.security.core.properties.SecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class ValidatorCodeFilter extends OncePerRequestFilter implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(ValidatorCodeFilter.class);

    /**
     * 系统配置信息
     */
    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 系统中的校验码处理器
     */
    @Autowired
    private ValidatorCodeProcessorHolder validatorCodeProcessorHolder;

    /**
     * 验证码校验失败处理器
     */
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 存放所有需要校验验证码的url
     */
    private Map<String,ValidatorCodeType> urlMap = new HashMap<>();

    /**
     * 验证请求url与配置的url是否匹配的工具类
     */
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();

        urlMap.put(SecurityBrowserConstant.DEFAULT_LOGIN_PROCESSING_URL_FORM,ValidatorCodeType.IMAGE);
        addUrlMap(securityProperties.getCode().getImage().getUrl(),ValidatorCodeType.IMAGE);

        urlMap.put(SecurityBrowserConstant.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,ValidatorCodeType.SMS);
        addUrlMap(securityProperties.getCode().getSms().getUrl(),ValidatorCodeType.SMS);
    }

    private void addUrlMap(String urlString, ValidatorCodeType image) {
        if (StrUtil.isNotEmpty(urlString)){
            String[] urls = StringUtils.splitByWholeSeparatorPreserveAllTokens(urlString,",");
            for (String url : urls){
                urlMap.put(url,image);
            }
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        ValidatorCodeType validatorCodeType = getValidatorCodeType(httpServletRequest);
        if (ObjectUtil.isNotNull(validatorCodeType)){
            logger.info("校验请求(" + httpServletRequest.getRequestURI() + ")中的验证码,验证码类型" + validatorCodeType);
            try {
                validatorCodeProcessorHolder.findValidatorCodeProcessor(validatorCodeType).validate(new ServletWebRequest(httpServletRequest, httpServletResponse));
                logger.info("恭喜,校验通过");
            }catch (ValidateCodeException validateCodeException){
                authenticationFailureHandler.onAuthenticationFailure(httpServletRequest,httpServletResponse,validateCodeException);
                return;//以防打印异常堆栈
            }
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    private ValidatorCodeType getValidatorCodeType(HttpServletRequest httpServletRequest) {
        ValidatorCodeType validatorCodeType = null;
        if (!StrUtil.endWithIgnoreCase(httpServletRequest.getMethod(),"get")){
            Set<String> urls = urlMap.keySet();
            for (String url : urls){
                if (antPathMatcher.match(httpServletRequest.getRequestURI(),url)){
                    validatorCodeType = urlMap.get(url);
                }
            }
        }
        return validatorCodeType;

    }


}
