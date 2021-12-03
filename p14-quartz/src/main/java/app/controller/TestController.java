package app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: bai
 * @Date: 2021/12/3 15:41
 */
@RestController
public class TestController {

    @GetMapping
    public String index(){
        return "Hello";
    }
}
