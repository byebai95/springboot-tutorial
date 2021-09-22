package app.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaProducer implements SuccessCallback<SendResult<String, String>>, FailureCallback {

    private final KafkaTemplate<String,String> template;

    public void sendMessage(String topic,String message){
        ListenableFuture<SendResult<String, String>> result =  template.send(topic,message);
        result.addCallback(this,this);
    }

    @Override
    public void onSuccess(SendResult<String, String> s) {
        log.info("发送成功，{}",s);
    }

    @Override
    public void onFailure(Throwable throwable) {
        log.info("发送失败，{}",throwable.getMessage());
    }
}
