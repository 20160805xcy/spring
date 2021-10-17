package com.xcy.importSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xcy
 * @Description 自定义逻辑返回需要导入的组件
 * @date 2021/10/17 11:36
 */
public class MyImportSelector implements ImportSelector {

    /**
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @return 类的全类名数组
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"com.xcy.Teacher", "com.xcy.Student"};
    }
}
