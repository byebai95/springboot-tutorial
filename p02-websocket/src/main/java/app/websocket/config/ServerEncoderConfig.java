package app.websocket.config;

import com.alibaba.fastjson.JSON;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * Object 对象即为 websocket 传输的信息模型，可修改为自定义
 */
public class ServerEncoderConfig implements Encoder.Text<Object>{

    @Override
    public String encode(Object messageVO) {
        try{
            return JSON.toJSONString(messageVO);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void init(EndpointConfig endpointConfig) {}

    @Override
    public void destroy() {}
}
