package com.huzhengxing.proxy;

/**
 * @Auther: Albert
 * @Date: 2019/12/19 19:06
 * @Contact: 1092144169@qq.com
 * @Description:
 */
public class BWMCar implements Car {
    public String color() {
        return "BWMCAR color";
    }

    public String price() {
        return "BWMCAR price";
    }

    @Override
    public void  run(String run) {
        System.out.println(run);
    }
}
