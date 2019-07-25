/**
 * @Author: LinK
 * @Date: 2019/7/19 10:31
 */

package com.qhl.leetcode.something;

import java.util.HashMap;
import java.util.Map;

public class StringTest {

    private static String appStr(String s){
        s = s + "bbb";
        return s;
    }
    public static void main(String[] args) {
//        String str1 = "abc";
//        String str2 = "abc";
//
//        System.out.println(str1 == str2);
//        String s = new String("aaa");
//        String ns = appStr(s);
//        System.out.println(ns.toString());

//        Map<String,Integer> map = new HashMap<>();
//        String s = "zhangsan";
//
//        map.put(s,1);
//
//        s = "lisi";
//        System.out.println(map.get(s));
//
//        System.out.println(map.get("zhangsan"));
//
//        String s1 = "a";
//        String s2 = s1;
//
//        map.put(s1,1);
//        s2 = "b";
//        s2.intern();
//        System.out.println(map.get(s1));
        String s1 = new String("hello");
        String intern1 = s1.intern();
        String s2 = "hello";
        System.out.println(s1 == s2);
        String s3 = new String("hello") + new String("hello");
        String intern3 = s3.intern();
        String s4 = "hellohello";
        System.out.println(s3 == s4);
    }
}
