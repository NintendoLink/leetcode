/**
 * @Author: LinK
 * @Date: 2019/8/30 11:04
 */

package com.qhl.leetcode.array;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。

 示例 1:

 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 输出: [2,2]
 示例 2:

 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 输出: [4,9]
 说明：

 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 我们可以不考虑输出结果的顺序。
 进阶:

 如果给定的数组已经排好序呢？你将如何优化你的算法？
 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

 */
public class IntersectSolution {

    /**
     * 思路
     * 1、使用List的remove方法
     * 2、排序
     * 3、使用HashMap
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] solution(int[] nums1, int[] nums2) {

        List<Integer> tempRes = new ArrayList<>();
        //思路1
//        if (nums1 == null || nums2 == null ||
//                nums1.length == 0 || nums2.length ==0){
//            return new int[0];
//        }
//
//        List<Integer> nums2List = new ArrayList<>();
//
//        for (int num2 : nums2){
//            nums2List.add(num2);
//        }
//        for (Integer num1 : nums1){
//            if (nums2List.remove(num1)){
//                tempRes.add(num1);
//            }
//        }
//
//        int[] resArr = new int[tempRes.size()];
//        int count = 0;
//        for (Integer ele : tempRes){
//            resArr[count++] = ele;
//        }
//
//        return resArr;

        //思路2
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int lastIndex = 0;
        for (int i =0;i<nums1.length;i++){
            for (int j = lastIndex;j <nums2.length;j++){
                if (nums1[i] == nums2[j]){
                    tempRes.add(nums1[i]);
                    lastIndex = j+1;
                    break;
                }
            }
        }


        int[] resArr = new int[tempRes.size()];
        int count = 0;
        for (Integer res : tempRes){
            resArr[count++] = res;
        }

        return resArr;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
//
//        int[] nums1 = {9,4,9,8,4};
//        int[] nums2 = {4,9,5};

        System.out.println(solution(nums1,nums2));
    }
}
