package com.huzhengxing.test;

/**
 * @Auther: Albert
 * @Date: 2020/2/6 14:39
 * @Contact: 1092144169@qq.com
 * @Description:
 */
public class Test {

    public class Node {
        Node left;
        Node right;
        int value;

        void find () {
            if (left != null ) {
                find();
            }

            System.out.println(value);

            if (right != null) {
                find();
            }
        }
    }


    public void inOrder(Node root) {

        root.find();
    }


    public static void main(String[] args) {


    }
}
