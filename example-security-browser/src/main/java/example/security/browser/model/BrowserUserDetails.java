package example.security.browser.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Setter
@Getter
public class BrowserUserDetails implements UserDetails {

    private static final long serialVersionUID = -778292079365504934L;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String userName;

    /***
     * 权限列表
     */
    private Collection<? extends GrantedAuthority> authorities;

    public BrowserUserDetails(){

    }

    public BrowserUserDetails(String userName,String password,Collection<? extends GrantedAuthority> authorities){
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
