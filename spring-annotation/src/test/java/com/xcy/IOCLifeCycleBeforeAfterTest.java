package com.xcy;

        import com.xcy.config.IOCPackageScanConfig;
        import org.junit.Test;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xcy
 * @Description
 * @date 2021/10/17 22:46
 */
public class IOCLifeCycleBeforeAfterTest {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(IOCPackageScanConfig.class);

        System.out.println("容器创建完成...");

        ((AnnotationConfigApplicationContext) context).close();

    }
}
