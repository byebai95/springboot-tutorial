package app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "app")
@SpringBootApplication
public class MybatisApp {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApp.class, args);
    }
}
