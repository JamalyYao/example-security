package example.security.core.validator.code;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidatorCodeProcessor {

    /***
     * 创建验证码
     * @param servletWebRequest
     */
    void create(ServletWebRequest servletWebRequest) throws Exception;

    /***
     * 验证码校验器
     * @param request
     */
    void validate(ServletWebRequest request);
}
