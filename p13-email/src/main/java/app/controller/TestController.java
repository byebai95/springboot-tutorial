package app.controller;

import app.manager.EmailManager;
import app.model.ToEmail;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: bai
 * @Date: 2021/12/2 14:18
 */
@AllArgsConstructor
@RestController
public class TestController {

    private EmailManager emailManager;


    @PostMapping("/simple")
    public String simpleEmail(@RequestBody ToEmail toEmail){
        return emailManager.sendSimpleEmail(toEmail);
    }

    @PostMapping("/html")
    public String htmlEmail(@RequestBody ToEmail toEmail){
        return emailManager.sendHtmlEmail(toEmail);
    }

    @PostMapping("/static")
    public String staticEmail(@RequestBody ToEmail toEmail){
        return emailManager.sendStaticEmail(toEmail);
    }

    @PostMapping("/attach")
    public String attachEmail(ToEmail toEmail, MultipartFile multipartFile){
        return emailManager.sendAttachEmail(toEmail,multipartFile);
    }
}
