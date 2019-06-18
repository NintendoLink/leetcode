/**
 * @Author: LinK
 * @Date: 2019/6/17 15:51
 */

package com.qhl.leetcode.dynamicprogramming;

/**
 *
 */
public class BanknoteSolution {

    /**
     * 递归算法
     * 当n比较大时，时间开销比较大
     * @param n
     * @return
     */
    public static int reSOlution(int n){

        if (n == 1 || n ==5 || n ==10){
            return 1;
        }else if (n <=0){
            return 999;
        }

        return Math.min(1+ reSOlution(n-1),Math.min(1+ reSOlution(n-5),1+reSOlution(n-10)));
    }

    public static void main(String[] args) {

        System.out.println(reSOlution(66));
    }
}
