package app.model.key;

/**
 * @Author: bai
 * @Date: 2021/10/29 10:56
 */
public class RedisCacheKey {

    public static String getCacheKey(String str){
        return String.format("token_%s",str);
    }
}
