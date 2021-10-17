package com.xcy;

        import com.xcy.config.MyImportSelectorConfig;
        import org.junit.Test;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xcy
 * @Description
 * @date 2021/10/17 11:47
 */
public class MyImportSelectorTest {

    @Test
    public void ImportSelectorTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyImportSelectorConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }

    }
}
