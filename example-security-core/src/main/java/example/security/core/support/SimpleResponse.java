package example.security.core.support;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleResponse {

    private Object content;

    public SimpleResponse(Object content){
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
