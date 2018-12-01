package example.security.core.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsCodeProperties {

    /**
     * 长度
     */
    private int length = 6;

    /***
     * 失效时间
     */
    private int expireIn = 600;

    /**
     * url链接
     */
    private String url;
}
