package app.websocket.config;

import javax.websocket.server.ServerEndpointConfig;

/**
 * @Author: bai
 * @Date: 2021/11/8 15:01
 *
 * //同源检测
 */
public class CustomConfigurator extends ServerEndpointConfig.Configurator{

    private static final String ORIGIN = "http://localhost:8080";

    @Override
    public boolean checkOrigin(String originHeaderValue) {
        if(originHeaderValue==null || originHeaderValue.trim().length()==0)
            return true;
        return ORIGIN.equals(originHeaderValue);
    }
}
