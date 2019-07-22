/**
 * @Author: LinK
 * @Date: 2019/7/22 11:33
 */

package com.qhl.leetcode.string;

/**
 * 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。

 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

 请找出在 t 中被添加的字母。

  

 示例:

 输入：
 s = "abcd"
 t = "abcde"

 输出：
 e

 解释：
 'e' 是那个被添加的字母。

 */
public class FindTheDifferenceSolution {

    /**
     * 思路
     * 1、位运算
     * @param s
     * @param t
     * @return
     */
    public static char solution(String s, String t) {

        if (s == null || t == null){
            return 0;
        }
        int res = 0;
        for (char ch :(s+ t).toCharArray()){
            res ^= (int) ch;
        }
        return (char) res;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";

        System.out.println(solution(s,t));
    }
}
