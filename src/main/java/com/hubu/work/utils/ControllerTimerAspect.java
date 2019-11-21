package com.hubu.work.utils;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @moduleName: ControllerTimerAspect
 * @description: 切面，日志打印接口被调用的时间与结果，
 * 
 * @author: 吴笛老师
 */
@Aspect
@Component
@Log
public class ControllerTimerAspect {

    /**
     * 将 所有 controller 层中的方法织入流程
     */
    @Pointcut("execution(public * com.hubu.work.web.controller.*.*(..))")
    public void controllerPointCut() {}

    /**
     * 将 baseController 层中的方法织入流程
     */
    @Pointcut("execution(public * com.hubu.work.web.common.BaseController.*(..))")
    public void baseControllerPointCut() {}

    @Around("controllerPointCut()")
    public Object aroundController(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        logCostTime(point, time);
        return result;
    }

    @Around("baseControllerPointCut()")
    public Object aroundBaseController(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        logCostTime(point, time);
        return result;
    }

    private void logCostTime(ProceedingJoinPoint joinPoint, long time) {
        Signature signature = joinPoint.getSignature();
        String methodName = signature.toString();
        log.info("method: " + signature.toString() + " cost:" + time + "ms");
    }
}