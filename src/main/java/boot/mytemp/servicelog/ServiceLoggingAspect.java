package boot.mytemp.servicelog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class ServiceLoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    // 해당 경로의 클래스, 메서드 호출시 로그 출력
/*    @Before("execution(* boot.mytemp.service.*.*(..))")
    public void logServiceMethodCall(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        logger.debug("Service(query) method called @@@ : [{}] in [{}]", methodName, className);
    }*/
}
