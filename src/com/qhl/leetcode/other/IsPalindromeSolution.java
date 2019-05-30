/**
 * @Author: LinK
 * @Date: 2019/5/30 9:25
 */

package com.qhl.leetcode.other;

/**
 * 9. 回文数（*）
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

 示例 1:

 输入: 121
 输出: true
 示例 2:

 输入: -121
 输出: false
 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 示例 3:

 输入: 10
 输出: false
 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class IsPalindromeSolution {

    /**
     * 思路
     * 1、利用字符比较
     * 2、利用数是否相等
     * @param x
     * @return
     */
    public static boolean solution(int x){

        if (x <0){
            return false;
        }
//        思路1 字符串比较
//        char[] tempChs = String.valueOf(x).toCharArray();
//
//        int head = 0;
//        int tail = tempChs.length-1;
//
//        while (head <= tail){
//            //算法的对称性，可以这样写。
//            if (tempChs[head++] != tempChs[tail--]){
//                return false;
//            }
//        }
//        return true;

        //思路2 整数相等
        int tempRes = 0;
        long level = 1;
        int temp = x;

        while (temp != 0){
            level *= 10;
            temp /=10;
        }

        level /= 10;
        temp = x;
        long level2 = 1;
        while (temp > 0){
            tempRes += level2 * (temp/level);
            temp %= level;
            level /=10;
            level2 *=10;
        }

        return tempRes == x;
    }

    public static void main(String[] args) {
        System.out.println(solution(1000000001));
    }
}
