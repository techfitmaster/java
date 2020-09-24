package com.huzhengxing.proxy;

/**
 * @Auther: Albert
 * @Date: 2019/12/19 19:46
 * @Contact: 1092144169@qq.com
 * @Description:
 */
public class Proxy {

    Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    void action(){
        subject.action();
    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy(new RealSubject());
        proxy.action();

    }

}
