/**
 * @Author: LinK
 * @Date: 2019/5/23 10:19
 */

package com.qhl.leetcode.other;

/**
 * 461. 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

 给出两个整数 x 和 y，计算它们之间的汉明距离。

 注意：
 0 ≤ x, y < 231.

 示例:

 输入: x = 1, y = 4

 输出: 2

 解释:
 1   (0 0 0 1)
 4   (0 1 0 0)
 ↑   ↑

 上面的箭头指出了对应二进制位不同的位置。

 */
public class HammingDistanceSolution {

    /**
     * 思路
     * 先做异或运算，然后再求异或结果中1的个数
     * @param x
     * @param y
     * @return
     */
    public static int solution(int x,int y){

        int count = 0;

        int tempRes = x^y;

        return oneCount(tempRes);
    }

    private static int oneCount(int n){

        int count = 0;
        while(n!=0){
            count++;
            n = n & (n-1);
        }

        return count;
    }

    /**
     * 朴实版本的数1算法
     * @param n
     * @return
     */
    private static int oneCountSimple(int n){

        int count = 0;
        while (n != 0){
            count = count + (count&1);
            count >>>= 1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(2,5));
        System.out.println(oneCount(5));
    }
}
