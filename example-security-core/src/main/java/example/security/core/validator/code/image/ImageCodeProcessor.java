package example.security.core.validator.code.image;

import example.security.core.validator.code.impl.AbstractValidatorCodeProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

@Component(value = "imageValidatorCodeProcessor")
public class ImageCodeProcessor extends AbstractValidatorCodeProcessor<ImageCode> {
    private static final Logger logger = LoggerFactory.getLogger(ImageCodeProcessor.class);

    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
    }
}
