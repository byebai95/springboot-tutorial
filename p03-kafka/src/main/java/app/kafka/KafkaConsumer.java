package app.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = {"message.push.test"})
    public void listenMessage(ConsumerRecord<String, String> record){
        log.info("消费者监听到消息，{}",record.toString());
    }
}
