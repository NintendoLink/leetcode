/**
 * @Author: LinK
 * @Date: 2019/7/22 10:05
 */

package com.qhl.leetcode.array;

/**
 * 896. 单调数列
 * 如果数组是单调递增或单调递减的，那么它是单调的。

 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。

 当给定的数组 A 是单调数组时返回 true，否则返回 false。

  

 示例 1：

 输入：[1,2,2,3]
 输出：true
 示例 2：

 输入：[6,5,4,4]
 输出：true
 示例 3：

 输入：[1,3,2]
 输出：false
 示例 4：

 输入：[1,2,4,5]
 输出：true
 示例 5：

 输入：[1,1,1]
 输出：true
 */
public class IsMonotonicSolution {

    /**
     * 思路
     * 1、两次比较即可
     * @param A
     * @return
     */
    public static boolean isMonotonic(int[] A) {

        if (A == null || A.length == 0){
            return false;
        }

        return isIncrease(A) || isDecrease(A);
    }

    private static boolean isDecrease(int[] a) {

        for (int i =0;i<a.length-1;i++){
            if (a[i] > a[i+1]){
                return false;
            }
        }
        return true;
    }

    private static boolean isIncrease(int[] a) {

        for (int i =0;i<a.length-1;i++){
            if (a[i] < a[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] A = {6,5,4,4};
//        int[] A = {1,3,2};
//        int[] A = {1,2,4,5};
        int[] A = {1,1,1};

        System.out.println(isMonotonic(A));
    }
}
