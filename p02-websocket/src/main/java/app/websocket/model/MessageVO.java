package app.websocket.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: bai
 * @Date: 2021/11/8 10:31
 */
@Accessors(chain = true)
@Data
public class MessageVO {

    private String event;

    private Object data;
}
