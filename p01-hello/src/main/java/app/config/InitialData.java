package app.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: bai
 * @Date: 2021/12/6 11:22
 */
@Component
public class InitialData implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("spring boot 启动预加载数据");
    }
}
