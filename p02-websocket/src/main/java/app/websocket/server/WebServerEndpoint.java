package app.websocket.server;

import app.websocket.config.ServerEncoderConfig;
import app.websocket.model.MessageVO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/socketServer/{userId}", encoders = {ServerEncoderConfig.class})
@Slf4j
@Data
@Component
public class WebServerEndpoint {

    private static final ConcurrentHashMap<String, Session> sessionMap = new ConcurrentHashMap<>();


    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) {
        sessionMap.put(userId, session);
        try {
            log.info("【onOpen】，{}", session);
        } catch (Exception e) {
            log.info("【onOpen】，{}", e.getMessage());
        }
    }

    @OnClose
    public void onClose(Session session) {
        Collection<Session> sessions = sessionMap.values();
        sessions.remove(session);
        log.info("【onClose】，{}", session.toString());
    }

    @OnMessage
    public void OnMessage(String message, Session session) {
        MessageVO messageVO = new MessageVO()
                .setEvent("heart")
                .setData(message);
        sendMessage(messageVO, session);
        log.info("【OnMessage】，{}", message);
    }

    @OnError
    public void onError(Throwable error, Session session) {
        log.error("【onError】，服务端错误");
    }

    /**
     * 单独发送
     *
     * @param msgObject
     * @param session
     */
    public void sendMessage(MessageVO msgObject, Session session) {
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
     *
     * @param msgObject
     * @param <T>
     */
    private <T> void sendBatchObject(MessageVO msgObject) {
        for (Map.Entry<String, Session> entry : sessionMap.entrySet()) {
            sendMessage(msgObject, entry.getValue());
        }
    }
}
