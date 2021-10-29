package app.service.impl;

import app.model.key.RedisCacheKey;
import app.model.vo.LoginVO;
import app.model.vo.UserInfoVO;
import app.utils.RedisUtils;
import app.utils.TokenUtils;
import app.model.param.LoginParam;
import app.model.response.ResponseInfo;
import app.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author: bai
 * @Date: 2021/10/29 10:30
 */
@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    private final RedisUtils redisUtils;

    @Override
    public ResponseInfo<?> login(LoginParam param) {
        //1.数据库校验
        String uid = UUID.randomUUID().toString().replace("-","").toLowerCase();
        //2.生成token
        String token = generateToken(uid);
        LoginVO loginVO = new LoginVO()
                .setUid(uid)
                .setToken(token);
        return ResponseInfo.ok(loginVO);
    }

    @Override
    public ResponseInfo<?> getUserInfo(String uid) {
        UserInfoVO userInfoVO = new UserInfoVO().setUid(uid).setUsername("admin").setPassword("123456");
        return ResponseInfo.ok(userInfoVO);
    }

    private String generateToken(String uid){
        String token = TokenUtils.createToken(uid);
        String cacheKey = RedisCacheKey.getCacheKey(uid);
        //todo 设置成功验证
        redisUtils.set(cacheKey,token,60);
        return token;
    }
}
