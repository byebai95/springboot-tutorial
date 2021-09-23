package app.controller;

import app.annotation.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @Log(username = "admin",value = "查询用户")
    @GetMapping
    public void test(){
      log.info("执行方法 test()");
    }
}
