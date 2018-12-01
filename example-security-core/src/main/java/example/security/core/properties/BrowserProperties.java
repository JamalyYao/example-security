package example.security.core.properties;

import example.security.core.constants.SecurityBrowserConstant;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BrowserProperties {

    private String loginPage = SecurityBrowserConstant.DEFAULT_LOGIN_PAGE_URL;

    private LoginResponseType loginType = LoginResponseType.JSON;

}
