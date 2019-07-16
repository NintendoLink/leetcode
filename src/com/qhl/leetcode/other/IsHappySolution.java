/**
 * @Author: LinK
 * @Date: 2019/7/16 11:04
 */

package com.qhl.leetcode.other;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。

 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

 示例: 

 输入: 19
 输出: true
 解释:
 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1
 */
public class IsHappySolution {

    /**
     * 思路
     * 1、1-9中只有1和7是“快乐数”，其他均不是“快乐数”， 故若当前的n等于1或7，则直接返回true;否则，若n < 10，且不等于1或7，则直接返回false。
     * 若程序仍未结束，则计算其每个位置上的数字的平方和sum，并对其递归执行上述过程。
     * 2、双指针算法
     * @param n
     * @return
     */
    public static boolean solution(int n){
        if (n == 1 || n == 7){
            return true;
        }

        if (n < 10){
            return false;
        }

        int temp = 0;
        while (n > 0){
            int yu = n % 10;

            temp += yu*yu;
            n /= 10;
        }

        return solution(temp);
    }

    public static void main(String[] args) {
        solution(10);
    }
}
