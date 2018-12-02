package example.security.dao.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_browser_remember_me")
public class BrowserRememberMe {
    /**
     * 序号
     */
    @Id
    private String series;

    /**
     * 用户名称
     */
    private String username;

    /**
     * token值
     */
    private String token;

    /**
     * 最后用户登录时间
     */
    @Column(name = "last_user_time")
    private Date lastUserTime;

    /**
     * 获取序号
     *
     * @return series - 序号
     */
    public String getSeries() {
        return series;
    }

    /**
     * 设置序号
     *
     * @param series 序号
     */
    public void setSeries(String series) {
        this.series = series == null ? null : series.trim();
    }

    /**
     * 获取用户名称
     *
     * @return username - 用户名称
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名称
     *
     * @param username 用户名称
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取token值
     *
     * @return token - token值
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置token值
     *
     * @param token token值
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * 获取最后用户登录时间
     *
     * @return last_user_time - 最后用户登录时间
     */
    public Date getLastUserTime() {
        return lastUserTime;
    }

    /**
     * 设置最后用户登录时间
     *
     * @param lastUserTime 最后用户登录时间
     */
    public void setLastUserTime(Date lastUserTime) {
        this.lastUserTime = lastUserTime;
    }
}