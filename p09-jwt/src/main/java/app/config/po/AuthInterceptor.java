package app.config.po;

import app.model.response.ResponseInfo;
import app.utils.RedisUtils;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: bai
 * @Date: 2021/10/29 11:31
 */
@AllArgsConstructor
@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    private final RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("拦截器-前置执行");
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            returnJson(response,"token 为空");
            return false;
        }
        System.out.println("Interce redisUtils:"+redisUtils);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("拦截器-中");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("拦截器-后置执行");
    }

    private void returnJson(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        ResponseInfo responseInfo = ResponseInfo.error(msg);
        printWriter.write(JSON.toJSONString(responseInfo));
    }

}
