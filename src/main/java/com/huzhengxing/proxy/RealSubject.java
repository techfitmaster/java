package com.huzhengxing.proxy;

/**
 * @Auther: Albert
 * @Date: 2019/12/19 19:45
 * @Contact: 1092144169@qq.com
 * @Description:
 */
public class RealSubject implements Subject {
    public void action() {
        System.out.println("do something");
    }
}
