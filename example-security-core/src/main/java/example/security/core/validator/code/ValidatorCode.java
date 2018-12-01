package example.security.core.validator.code;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ValidatorCode {

    public String code;

    public LocalDateTime expireTime;

    public long expireIn;

    public ValidatorCode(String code,LocalDateTime expireTime,long expireIn){
        this.code = code;
        this.expireTime = expireTime;
        this.expireIn = expireIn;
    }

    public ValidatorCode(String code,long expireIn){
        this.code = code;
        this.expireIn = expireIn;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expireTime);
    }
}
