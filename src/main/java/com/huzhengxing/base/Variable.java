package com.huzhengxing.base;

/**
 * 基本变量
 */
public class Variable {

    public static void main(String[] args) {

        //--------byte----------
        System.out.println("------byte----------");
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Math.pow(2, 18));


        System.out.println("-----(整型)Integer Literals-------");
        // The number 26, in decimal
        int decVal = 26;
        //  The number 26, in hexadecimal
        int hexVal = 0x1a;
        // The number 26, in binary
        int binVal = 0b11010;
        System.out.println(decVal);
        System.out.println(hexVal);
        System.out.println(binVal);


        System.out.println("-------(浮点类型)Floating-Point Literals");
        double d1 = 123.4;
        // same value as d1, but in scientific notation
        double d2 = 1.234e2;
        float f1  = 123.4f;
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(f1);
    }


}
