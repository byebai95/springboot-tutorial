package app.controller;

import app.VO.UserVO;
import app.mapstruct.UserMapper;
import app.model.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class TestController {

    private final UserMapper userMapper;

    @GetMapping
    public UserVO getUserInfo(){
        User user = new User("1001", "lucy");
        return userMapper.toVO(user);
    }
}
