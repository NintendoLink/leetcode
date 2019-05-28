/**
 * @Author: LinK
 * @Date: 2019/5/28 10:06
 */

package com.qhl.leetcode.bytes;

/**
 * 868. 二进制间距
 * 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。

 如果没有两个连续的 1，返回 0 。



 示例 1：

 输入：22
 输出：2
 解释：
 22 的二进制是 0b10110 。
 在 22 的二进制表示中，有三个 1，组成两对连续的 1 。
 第一对连续的 1 中，两个 1 之间的距离为 2 。
 第二对连续的 1 中，两个 1 之间的距离为 1 。
 答案取两个距离之中最大的，也就是 2 。
 示例 2：

 输入：5
 输出：2
 解释：
 5 的二进制是 0b101 。
 示例 3：

 输入：6
 输出：1
 解释：
 6 的二进制是 0b110 。
 示例 4：

 输入：8
 输出：0
 解释：
 8 的二进制是 0b1000 。
 在 8 的二进制表示中没有连续的 1，所以返回 0 。
 */
public class BinaryGapSolution {

    /**
     * 思路：
     * 利用移位运算常规计数即可
     * @param N
     * @return
     */
    public static int solution(int N){

        int count = 0;
        int res = 0;
        int temp;
        boolean flag = false;
        while (N>0){
            temp = N&1;
            N >>>= 1;
            if (temp == 1){
                if (res < count){
                    res = count;
                }
                flag = true;
                count =0;
            }
            if (flag){
                count+=1;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(solution(8));
    }
}
