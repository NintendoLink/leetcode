/**
 * @Author: LinK
 * @Date: 2019/7/29 11:39
 */

package com.qhl.leetcode.other;

/**
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 注意：给定 n 是一个正整数。

 示例 1：

 输入： 2
 输出： 2
 解释： 有两种方法可以爬到楼顶。
 1.  1 阶 + 1 阶
 2.  2 阶
 示例 2：

 输入： 3
 输出： 3
 解释： 有三种方法可以爬到楼顶。
 1.  1 阶 + 1 阶 + 1 阶
 2.  1 阶 + 2 阶
 3.  2 阶 + 1 阶
 */
public class ClimbStairsSolution {

    /**
     * 思路
     * 1、递归（较大数值会一处，超时）
     * 2、循环算法，比较清晰
     * @param n
     * @return
     */
    public static int solution(int n) {

//        if (n<1){
//            return 0;
//        }else if (n<2){
//            return 1;
//        }else if (n<3){
//            return 2;
//        }else {
//            return solution(n-2) + solution(n-1);
//        }

        if (n<1){
            return 0;
        }else if (n<2){
            return 1;
        }else if (n<3){
            return 2;
        }
        int res = 0;
        int previous = 1;
        int next = 2;
        for (int i =3;i<=n;i++){
            res = previous + next;

            previous = next;
            next = res;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution(2));
    }
}
