package app.aop;

import app.annotation.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class LogAspect {


    @Pointcut("@annotation(app.annotation.Log)")
    public void pointCut() {
    }

    @Before("pointCut() && @annotation(myLog)")
    public void doSomething(JoinPoint joinPoint, Log myLog) {
        //方法名称
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        log.info("方法名称，{}", methodName);

        log.info("{} 执行了 {}",myLog.username(),myLog.value());
    }


}
