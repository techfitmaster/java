package com.huzhengxing.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: Albert
 * @Date: 2019/12/19 20:13
 * @Contact: 1092144169@qq.com
 * @Description:
 */
public class TargetInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object obj = methodProxy.invokeSuper(o, objects);
        return obj;
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BWMCar.class);
        enhancer.setCallback(new TargetInterceptor());
        BWMCar car  = (BWMCar) enhancer.create();
        System.out.println(car.color());
        System.out.println(car.price());
        car.run("run...");
    }
}
