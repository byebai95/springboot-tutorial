package app.config.po;

import app.model.key.RedisCacheKey;
import app.model.response.ResponseInfo;
import app.utils.RedisUtils;
import app.utils.TokenUtils;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: bai
 * @Date: 2021/10/29 11:03
 */
@AllArgsConstructor
@Slf4j
@Component
public class AuthFilter implements Filter {

    private final RedisUtils redisUtils;

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
        log.info("filter-项目启动执行");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        log.info("filter-项目启动执行中");
        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        final String token = httpServletRequest.getHeader("token");
        if(token == null){
            throw new ServletException("Missing or invalid Token");
        }

        try{
            String walletId = TokenUtils.parseToken(token);
            String redisCacheKey = RedisCacheKey.getCacheKey(walletId);
            long tokenExpireTime = redisUtils.getExpire(redisCacheKey);
            if (tokenExpireTime <= 0) {
                throw new RuntimeException();
            }
        }catch (Exception e){
            returnJson((HttpServletResponse)response,"Invalid Token");
            return;
        }

        filterChain.doFilter(request,response);

    }

    @Override
    public void destroy() {
        log.info("filter-项目关闭执行");
    }

    private void returnJson(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        ResponseInfo<String> responseInfo = ResponseInfo.error(msg);
        printWriter.write(JSON.toJSONString(responseInfo));
    }
}
