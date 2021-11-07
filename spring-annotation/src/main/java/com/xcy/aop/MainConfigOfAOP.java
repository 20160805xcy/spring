package com.xcy.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author xcy
 * @Description
 * @date 2021/11/7 22:26
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {
    /*
      AOP:动态代理，指在程序允许期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
      1.导入aop模块,SpringAOP:Spring-aspects
      2.定义一个业务逻辑类（MathCalculator），在业务逻辑运行的时候将日志进行打印，方法运行前，后
      3.顶一个日志切面类（LogAspects）,切面类里面的方法需要动态感知MathCalculator.div运行到哪里，然后执行
       通知方法：
           前置通知(@Before)：logStart()，在目标方法(div())运行之前运行
           后置通知(@After)：logEnd()，  在目标方法(div())运行之后运行（无论方法是正常还是异常，都会调用后置通知）
           返回通知(@AfterReturning)：logReturn()，在目标方法(div())正常返回之后运行
           异常通知(@AfterThrowing)：logException()，在目标方法(div())出现异常之后运行
           环绕通知(@Around)：动态代理，手动推进目标方法运行（joinPoint.procced()）
      4.给切面类的目标方法标注何时何地的运行（通知注解）
      5.将切面类和业务逻辑类（目标方法所在类）都加入到容器中；
      6.必需告诉spring哪个类是切面类（给切面加一个注解，@Aspect）
      7.给配置类加 @EnableAspectJAutoProxy 开启基于注解的aop模式

           总结：  三步
           1.将业务逻辑组件和切面类都加入到容器中；告诉spring哪个是切面类（@Aspect）
           2.在切面类上的每一个通知方法上标注通知注解，告诉spring何时何地运行（切入点表达式）
           3.开启基于注解的aop模式；@EnableAspectJAutoProxy
     */

    // 将业务逻辑类加入到容器中
    @Bean
    public MathCalculator calculator() {
        return new MathCalculator();
    }

    // 将切面类也加入到容器中
    @Bean
    public LogAspects aspects() {
        return new LogAspects();
    }

}
