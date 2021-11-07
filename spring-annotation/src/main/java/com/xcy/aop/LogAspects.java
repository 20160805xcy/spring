package com.xcy.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author xcy
 * @Description
 * @Aspect 告诉spring当前类是一个切面类
 * @date 2021/11/7 22:32
 */
@Aspect
public class LogAspects {

    /**
     * 抽取公共的切入点表达式
     * 1.本类引用
     * 2.其他的切面引用
     */
    @Pointcut("execution(public int com.xcy.aop.MathCalculator.*(..))")
    public void pointCut() {
    }


    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("@Before 正在" + joinPoint.getSignature().getName() + " 方法 运行前执行...参数列表是：{" + Arrays.asList(args) + "}");
    }

    @After("com.xcy.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("@After 正在" + joinPoint.getSignature().getName() + " 方法 运行后执行...参数列表是：{" + Arrays.asList(args) + "}");
    }

    // JoinPoint 参数必需在参数列表里面的第一个，不然无法正常运行
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("@AfterReturning 正在" + joinPoint.getSignature().getName() + "方法运行完成后返回...运行结果：{" + result + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("@AfterThrowing 除法异常...异常信息：{" + exception + "}");
    }

}
