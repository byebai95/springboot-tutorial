package app.websocket.server;

import app.websocket.config.ServerEncoderConfig;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/socketServer/{userId}", encoders = {ServerEncoderConfig.class})
@Slf4j
@Data
@Component
public class WebServerEndpoint {

    private static final ConcurrentHashMap<String, Session> sessionMap = new ConcurrentHashMap<>();
    private static final CopyOnWriteArraySet<WebServerEndpoint> serverSet = new CopyOnWriteArraySet<>();
    private Session session;

    @OnOpen
    public void onOpen(@PathParam("userId")String userId, Session session){
        if(userId!=null){
            sessionMap.put(userId,session);
        }
        this.session = session;
        serverSet.add(this);
        try {
            log.info("连接成功，{}",session.toString());
        }catch (Exception e){
            log.info("连接失败，{}",e.getMessage());
        }
    }

    @OnClose
    public void onClose(Session session){
        serverSet.remove(this);
        Collection<Session> sessions = sessionMap.values();
        sessions.remove(this.session);
        log.info("连接关闭，{}",session.toString());
    }

    @OnMessage
    public void OnMessage(String message,Session session){
        log.info("session {} 收到消息，{}",session.toString(),message);
    }

    @OnError
    public void  onError(Throwable error,Session session){
        log.error("服务端错误");
    }

    /**
     * 单独发送
     * @param msgObject
     * @param session
     * @param <T>
     */
    public <T> void sendMessage(Object msgObject, Session session) {
        if (!session.isOpen()) {
            return;
        }
        try {
            session.getBasicRemote().sendObject(msgObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 群发消息
     * @param msgObject
     * @param <T>
     */
    private <T> void sendBatchObject(Object msgObject) {
        serverSet.forEach(
                item -> item.sendMessage(msgObject, item.getSession())
        );
    }
}
