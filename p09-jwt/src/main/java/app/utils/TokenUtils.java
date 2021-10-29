package app.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Author: bai
 * @Date: 2021/10/29 10:44
 */
public class TokenUtils {

    private static final String SUBJECT = "bs";

    private static final String KEY = "author";

    //生成token
    public static String createToken(String id){
        JwtBuilder jwtBuilder = Jwts.builder().setId(id).setSubject(SUBJECT).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,KEY);
        return jwtBuilder.compact();
    }

    //解析token
    public static String parseToken(String token){
        Claims claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        return claims.getId();
    }

}
