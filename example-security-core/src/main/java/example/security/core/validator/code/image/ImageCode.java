package example.security.core.validator.code.image;

import example.security.core.validator.code.ValidatorCode;
import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

@Setter
@Getter
public class ImageCode extends ValidatorCode {

    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn){
        super(code, expireIn);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime,long expireIn){
        super(code, expireTime,expireIn);
        this.image = image;
    }
}
