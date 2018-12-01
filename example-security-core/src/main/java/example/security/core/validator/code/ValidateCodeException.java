package example.security.core.validator.code;

import org.springframework.security.core.AuthenticationException;

public class ValidateCodeException extends AuthenticationException {


    private static final long serialVersionUID = 4614132326770579526L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
