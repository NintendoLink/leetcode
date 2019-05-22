/**
 * @Author: LinK
 * @Date: 2019/5/22 14:08
 */

package com.qhl.leetcode.array;

import java.util.Arrays;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。



 示例 1：

 输入：[-4,-1,0,3,10]
 输出：[0,1,9,16,100]
 示例 2：

 输入：[-7,-3,2,3,11]
 输出：[4,9,9,49,121]


 提示：

 1 <= A.length <= 10000
 -10000 <= A[i] <= 10000
 A 已按非递减顺序排序。
 */
public class SortedSquaresSolution {

    /**
     * 思路
     * 1、普通的算法，时间复杂度n*logn
     * 2、双指针算法，时间负责的 n
     * @param A
     * @return
     */
    public static int[] solution(int[] A) {

        if (A == null || A.length ==0){
            return A;
        }

        //思路1普通的实现算法
//        int[] res = new int[A.length];
//        for (int i =0;i<A.length;i++){
//            res[i] =  A[i] * A[i];
//        }
//
//        Arrays.sort(res);
//        return res;

        //思路2，双指针算法，实现的不够优雅
        int[] temp = new int[A.length];
        int[] res = new int[A.length];

        int zeroIndex =-1;
        for (int i = 0;i<A.length;i++){
            temp[i] = A[i] * A[i];
        }

        for (int i = 0;i<A.length-1;i++){
            if ( A[i] <= 0 && A[i+1] >=0){
                zeroIndex = i;
            }
        }

        int fu = zeroIndex;
        int zheng = zeroIndex+1;
        int count = 0;
        while (fu >= 0 && zheng < temp.length){
            if (temp[fu] >= temp[zheng]){
                res[count++] = temp[zheng];
                zheng++;
            }else {
                res[count++] = temp[fu];
                fu--;
            }
        }

        while (fu>=0){
            res[count++] = temp[fu--];
        }
        while (zheng< temp.length){
            res[count++] = temp[zheng++];
        }
        return res;


    }

    public static void main(String[] args) {
//        int[] A = {-2,0};
//        for (Integer integer:solution(A)){
//            System.out.println(integer);
//        }

        int[] A = {0,2};
        int zeroIndex =-1;
        for (int i = 0;i<A.length;i++){
            if (A[i] >=0){
                zeroIndex = i;
                break;
            }
        }

        System.out.println(zeroIndex);
    }
}
