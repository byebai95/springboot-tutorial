package app.controller;

import app.mapper.UserMapper;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public List<User> getInfo(){
        return userMapper.getUserList();
    }
}
