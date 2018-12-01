package example.security.core.validator.code;

import example.security.core.constants.SecurityBrowserConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ValidatorController {

    @Autowired
    private ValidatorCodeProcessorHolder validatorCodeProcessorHolder;

    @RequestMapping(SecurityBrowserConstant.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception{
        validatorCodeProcessorHolder.findValidatorCodeProcessor(type).create(new ServletWebRequest(request, response));
    }
}
