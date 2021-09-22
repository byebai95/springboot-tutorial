package app.controller;

import app.kafka.KafkaProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class TestController {

    private final KafkaProducer kafkaProducer;

    @GetMapping("/sendMessage")
    private void sendMessage(){
        kafkaProducer.sendMessage("message.push.test","test-message");
    }
}
