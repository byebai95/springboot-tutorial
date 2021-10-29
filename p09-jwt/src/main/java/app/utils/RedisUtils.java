package app.utils;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: bai
 * @Date: 2021/10/29 10:45
 */
@AllArgsConstructor
@Component
public class RedisUtils {

    private final StringRedisTemplate stringRedisTemplate;

    //默认永久存储
    private static final long DEFAULT_EXPIRE_TIME = -1;

    public <T> void set(String key,T value,long expireTime){
        String data = JSON.toJSONString(value);
        stringRedisTemplate.opsForValue().set(key,data);
        if(expireTime > 0){
            stringRedisTemplate.expire(key,expireTime, TimeUnit.SECONDS);
        }
    }

    public <T> T get(String key, Class<T> clazz){
        String value = stringRedisTemplate.opsForValue().get(key);
        if(value == null){
            return null;
        }
        return JSON.parseObject(value,clazz);
    }

    public long getExpire(String key) {
        return stringRedisTemplate.getExpire(key);
    }

}
