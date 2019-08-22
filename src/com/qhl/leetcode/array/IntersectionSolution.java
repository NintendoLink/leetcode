/**
 * @Author: LinK
 * @Date: 2019/8/22 10:37
 */

package com.qhl.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。

 示例 1:

 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 输出: [2]
 示例 2:

 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 输出: [9,4]
 说明:

 输出结果中的每个元素一定是唯一的。
 我们可以不考虑输出结果的顺序。
 */
public class IntersectionSolution {

    /**
     * 思路
     * 1、直接用集合的查找算法
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] solution(int[] nums1, int[] nums2) {

        int[] res = new int[0];

        if (nums1 == null || nums1.length == 0 ||
                nums2 == null || nums2.length ==0){
            return res;
        }

//        Set<Integer> num1Set = new HashSet<>();
//        Set<Integer> resSet = new HashSet<>();
//        for (Integer integer: nums1){
//            num1Set.add(integer);
//        }
//
//        for (Integer integer:nums2){
//            if (num1Set.contains(integer)){
//                resSet.add(integer);
//            }
//        }
//
//        res = new int[resSet.size()];
//
//        int temp = 0;
//        for (Integer integer: resSet){
//            res[temp++] = integer;
//        }

        return res;
    }

    public static void main(String[] args) {
//        int[] num1 = {1,2,2,1};
//        int[] num2 =  {2,2};

        int[] num1 = {4,9,5};
        int[] num2 =  {9,4,9,8,4};

        solution(num1,num2);
    }
}
