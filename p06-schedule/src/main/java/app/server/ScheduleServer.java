package app.server;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduleServer {

    @Scheduled(cron = "0/3 * * * * ?")
    public void alert(){
        log.info("alert ...");
    }
}
