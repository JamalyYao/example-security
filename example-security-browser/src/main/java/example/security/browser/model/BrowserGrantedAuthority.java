package example.security.browser.model;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class BrowserGrantedAuthority implements GrantedAuthority {

    private static final long serialVersionUID = 2164548245873797605L;

    /**
     * 菜单链接
     */
    private String url;

    /***
     * 动作方法
     */
    private String method;

    /***
     * 关联资源
     */
    private String permission;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String getAuthority() {
        return permission;
    }
}
