/**
 * @Author: LinK
 * @Date: 2019/6/20 9:59
 */

package com.qhl.leetcode.other;

/**
 * 231. 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

 示例 1:

 输入: 1
 输出: true
 解释: 20 = 1
 示例 2:

 输入: 16
 输出: true
 解释: 24 = 16
 示例 3:

 输入: 218
 输出: false
 */
public class IsPowerOfTwoSolution {

    /**
     * 思路
     * 1、乘法思路
     * 2、取余思路
     * 3、移位思路
     * @param n
     * @return
     */
    public static boolean solution(int n){


//        思路1
//        double powOfTow = 1;
//
//        while (powOfTow <= n){
//            if (powOfTow == n){
//                return true;
//            }
//
//            powOfTow *= 2;
//        }


        //思路2
//        while (n % 2 != 1 && n > 1){
//            n /= 2;
//        }
//
//        if (n ==1){
//            return true;
//        }
//        return false;

        //思路3
//        return (n & (n-1)) ==0;

        return (n &(-n)) == n;

    }

    public static void main(String[] args) {
        System.out.println(solution(128));
    }
}
