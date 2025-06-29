package app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户管理")
@RestController
public class UserController {

    @ApiOperation("获取用户信息")
    @GetMapping("/users")
    public String getUserInfo(){
        return "success";
    }
}
