package app.controller;

import cn.hutool.core.lang.Snowflake;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static Snowflake snowflake = new Snowflake();

    @GetMapping
    public Long generateId(){
        return snowflake.nextId();
    }
}
