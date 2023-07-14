package app.controller;

import app.model.param.LoginParam;
import app.model.response.ResponseInfo;
import app.model.vo.LoginVO;
import app.model.vo.UserInfoVO;
import app.service.LoginService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: bai
 * @Date: 2021/10/29 10:01
 */

@AllArgsConstructor
@RestController
public class LoginController {

    private final LoginService loginService;


    @ApiResponses({@ApiResponse(code = 200,message = "ok",response =LoginVO.class)})
    @PostMapping("/login")
    public ResponseInfo<?> login(@RequestBody LoginParam param){
        return loginService.login(param);
    }

    @ApiResponses({@ApiResponse(code = 200,message = "ok",response = UserInfoVO.class)})
    @GetMapping("/check/getUserInfo")
    public ResponseInfo<?> getUserInfo(@RequestParam String uid){
        return loginService.getUserInfo(uid);
    }




}
