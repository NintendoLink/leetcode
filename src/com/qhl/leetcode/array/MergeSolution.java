/**
 * @Author: LinK
 * @Date: 2019/5/22 15:19
 */

package com.qhl.leetcode.array;

import java.util.Arrays;

/**
 *
 88. 合并两个有序数组
 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

 说明:

 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 示例:

 输入:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 输出: [1,2,2,3,5,6]
 */
public class MergeSolution {

    /**
     * 思路
     * 1、最普通的排序法
     * 2、双指针法
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void solution(int[] nums1, int m, int[] nums2, int n){

        if (nums1 == null || nums1.length ==0||
                m+n > nums1.length){
            return;
        }

//        int[] temp = new int[m+n];
//
//        int nums1Index = 0;
//        int nums2Index = 0;
//        for (;nums1Index < m;nums1Index++){
//            temp[nums1Index] = nums1[nums1Index];
//        }
//
//        for (;nums2Index<n;nums2Index++){
//            temp[nums1Index+nums2Index] = nums2[nums2Index];
//        }
//
//        Arrays.sort(temp);
//
//        for (int i =0;i<temp.length;i++){
//            nums1[i] = temp[i];
//        }
        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;

        while (p1>=0&& p2>=0){
            if (nums1[p1] < nums2[p2]){
                nums1[p--] = nums2[p2--];
            }else {
                nums1[p--] = nums1[p1--];
            }
        }

        while (p2>=0){
            nums1[p--] = nums2[p2--];
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};

        solution(num1,3,num2,3);

        for (Integer integer:num1){
            System.out.print(integer + " ");
        }
    }
}
