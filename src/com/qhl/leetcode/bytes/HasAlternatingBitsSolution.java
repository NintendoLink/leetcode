/**
 * @Author: LinK
 * @Date: 2019/8/9 16:46
 */

package com.qhl.leetcode.bytes;

/**
 * 693. 交替位二进制数
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。

 示例 1:

 输入: 5
 输出: True
 解释:
 5的二进制数是: 101
 示例 2:

 输入: 7
 输出: False
 解释:
 7的二进制数是: 111
 示例 3:

 输入: 11
 输出: False
 解释:
 11的二进制数是: 1011
  示例 4:

 输入: 10
 输出: True
 解释:
 10的二进制数是: 1010
 */
public class HasAlternatingBitsSolution {

    /**
     * 思路
     * 1、直接使用位运算即可
     * @param n
     * @return
     */
    public static boolean solution(int n){

        int m = n>>>1;
        return ((n ^ m) & ((n ^ m)+1)) ==0;
    }

    public static void main(String[] args) {
        int n =11;
        System.out.println(solution(n));
    }
}
