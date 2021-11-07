package com.xcy.aop;

/**
 * @author xcy
 * @Description 业务逻辑-数学计算
 * @date 2021/11/7 22:55
 */
public class MathCalculator {

    public int div(int i, int j) {
        System.out.println("MathCalculator.div()... 正在执行");
        return i / j;
    }
}
