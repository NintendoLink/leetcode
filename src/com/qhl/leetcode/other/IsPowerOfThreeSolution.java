/**
 * @Author: LinK
 * @Date: 2019/8/23 10:07
 */

package com.qhl.leetcode.other;

/**
 * 326. 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。

 示例 1:

 输入: 27
 输出: true
 示例 2:

 输入: 0
 输出: false
 示例 3:

 输入: 9
 输出: true
 示例 4:

 输入: 45
 输出: false
 进阶：
 你能不使用循环或者递归来完成本题吗

 */
public class IsPowerOfThreeSolution {

    /**
     * 思路
     * 1、两种循环
     * 2、利用数论
     * @param n
     * @return
     */
    public static boolean solution(int n) {

        //思路1
//        long temp = 1;
//        while (temp <= n && temp < 2147483647){
//            if (temp ==  n){
//                return true;
//            }
//            System.out.println(temp);
//            temp *= 3;
//        }
//        return false;

//        int remainder;
//        while (n>1){
//            remainder = n % 3;
//            if (remainder !=0){
//                return false;
//            }
//            n /= 3;
//        }
//
//        return  n==1;

        //思路2
        return n > 0 && 1162261467%n == 0;
    }

    public static void main(String[] args) {
        solution(9);
    }
}
