package com.huzhengxing.collection.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: Albert
 * @Date: 2019/12/20 10:40
 * @Contact: 1092144169@qq.com
 * @Description:
 */
public class StreamTest {

    public static void main(String[] args) {

        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);

        List<Long> collect = list.stream().map(l -> {
           if (l%2==0) {
               return null;
           } else {
               return l;
           }
        }).collect(Collectors.toList());

        System.out.println("111");

    }
}
