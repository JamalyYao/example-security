package example.security.core.validator.code;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidatorCodeGenerator {

    /***
     * 生成验证码信息
     * @param request
     * @return
     */
    ValidatorCode generator(ServletWebRequest request);
}
