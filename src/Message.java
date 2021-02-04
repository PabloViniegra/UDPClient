import java.io.Serializable;
import java.util.UUID;

public class Message implements Serializable {
    private String id;
    private String msg;

    public Message(String msg) {
        this.id = UUID.randomUUID().toString().replace("-", "");;
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
