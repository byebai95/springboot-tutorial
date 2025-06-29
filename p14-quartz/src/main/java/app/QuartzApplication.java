package app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: bai
 * @Date: 2021/12/3 15:41
 */

@MapperScan(basePackages = "app.mapper")
@SpringBootApplication
public class QuartzApplication {

    public static void main(String[] args) {

        SpringApplication.run(QuartzApplication.class, args);

    }

}
