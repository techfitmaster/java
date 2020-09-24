package com.huzhengxing.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: Albert
 * @Date: 2019/12/19 19:08
 * @Contact: 1092144169@qq.com
 * @Description:
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private Object realSubject;

    public InvocationHandlerImpl(Object realSubject) {
        this.realSubject = realSubject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用对象前
        //调用对象
        Object obj = method.invoke(realSubject, args);
        //调用对象
        return obj;
    }


    public static void main(String[] args) {
        Car car = new BWMCar();
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(car);
        Car proxyInstance  = (Car) Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(), Car.class.getInterfaces(), invocationHandler);
        System.out.println(proxyInstance.color());
        System.out.println(proxyInstance.price());


    }
}
