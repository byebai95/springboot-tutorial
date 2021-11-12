package app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: bai
 * @Date: 2021/11/12 10:40
 */
@RestController
public class WebController {

    @GetMapping("/")
    public String hello(){
        return "Hello,Docker";
    }
}
