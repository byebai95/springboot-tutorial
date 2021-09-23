package app.controller;

import app.util.MessageUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class TestController {


    @GetMapping("/get")
    public String getStr(){
        return MessageUtils.getMsg("success");
    }
}
