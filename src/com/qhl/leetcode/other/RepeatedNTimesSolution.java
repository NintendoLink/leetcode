/**
 * @Author: LinK
 * @Date: 2019/8/21 16:11
 */

package com.qhl.leetcode.other;

/**
 * 961. 重复 N 次的元素

 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。

 返回重复了 N 次的那个元素。

 示例 1：

 输入：[1,2,3,3]
 输出：3
 示例 2：

 输入：[2,1,2,5,3,2]
 输出：2
 示例 3：

 输入：[5,1,5,2,5,3,5,4]
 输出：5
 */
public class RepeatedNTimesSolution {

    /**
     * 思路
     * 1、简单的重复比较即可
     * @param A
     * @return
     */
    public static int solution(int[] A) {

        if (A == null || A.length ==0){
            return 0;
        }

        int temp = A[0];
        for (int i = 1;i<A.length;i++){
            if (A[i] == temp){
                return A[i];
            }else {
                temp = A[i];
            }
        }

        if (A[0] == A[3]){
            return A[0];
        }
        if (A[0] == A[2]){
            return A[0];
        }
        if (A[A.length-1] == A[A.length-3]){
            return A[A.length-1];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {5,1,5,2,5,3,5,4};
        System.out.println(solution(array));

    }
}
