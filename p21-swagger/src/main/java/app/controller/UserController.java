package app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "user-tag")
@RestController
public class UserController {

    @Operation(summary = "添加文章", description = "添加新的文章", tags = "Article",method = "get")
    @GetMapping("/users")
    public String getUserInfo(){
        return "success";
    }
}
