package com.gSpring.common.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;

@Aspect
public class AspectjAdvisor {
	private Logger logger = Logger.getLogger(getClass());
	
    @Pointcut("execution(public * com.gSpring.controller.MainController.*(..))" )
    private void targetMethod(){}
    
    @Before("targetMethod()")
    public void beforeTrace(JoinPoint jp){
    	
    }
    
    @Around("targetMethod()")
 	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {

 		String signatureString = joinPoint.getSignature().toShortString();

 		StopWatch sw = new LoggingStopWatch();
 		try {
 			logger.info("joinPoint.proceed()");
 			logger.info("■■■■■■■■■ joinPoint.proceed()_start ■■■■■■■■■");
 			Object result = joinPoint.proceed();
 			//Thread.sleep(2000);
 			logger.info("■■■■■■■■■ joinPoint.proceed()_end ■■■■■■■■■");
 			return result;

 		} finally {
 			sw.stop("실행시간(ms)",signatureString);
 			sw.getMessage();
 		}
 	}
    
}