/**
 * @Author: LinK
 * @Date: 2019/5/20 11:06
 */

package com.qhl.leetcode.string;

/**
 * 709. 转换成小写字母
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 * 示例 1：

 输入: "Hello"
 输出: "hello"
 示例 2：

 输入: "here"
 输出: "here"
 示例 3：

 输入: "LOVELY"
 输出: "lovely"
 */
public class ToLowerCaseSolution {

    /**
     * 常规解法
     * @param str
     * @return
     */
    public static String solution(String str){

        StringBuffer resSb = new StringBuffer("");

        if (str == null || str.length()== 0){
            return resSb.toString();
        }

        for (Character ch:str.toCharArray()){
            resSb.append(String.valueOf(ch >= 65 && ch <= 90? String.valueOf((char)(ch +32)):ch));
        }

        return resSb.toString();
    }

    public static void main(String[] args) {
        String str = "al&phaBET";

        System.out.println(solution(str));
    }
}
