/**
 * @Author: LinK
 * @Date: 2019/8/22 11:01
 */

package com.qhl.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。

 nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。

 示例 1:

 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 输出: [-1,3,-1]
 解释:
 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 示例 2:

 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 输出: [3,-1]
 解释:
     对于num1中的数字2，第二个数组中的下一个较大数字是3。
 对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 注意:

 nums1和nums2中所有元素是唯一的。
 nums1和nums2 的数组大小都不超过1000。

 */
public class NextGreaterElementSolution {

    /**
     * 思路
     * 1、常规方法
     * 2、通过Stack、HashMap解决

     先遍历大数组nums2，首先将第一个元素入栈；
     继续遍历，当当前元素小于栈顶元素时，继续将它入栈；当当前元素大于栈顶元素时，栈顶元素出栈，此时应将该出栈的元素与当前元素形成key-value键值对，存入HashMap中；
     当遍历完nums2后，得到nums2中元素所对应的下一个更大元素的hash表；
     遍历nums1的元素在hashMap中去查找‘下一个更大元素’，当找不到时则为-1。
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] solution(int[] nums1, int[] nums2) {

        int[] res = new int[0];
        if (nums1 == null || nums1.length == 0 ||
                nums2 == null || nums2.length == 0){
            return res;
        }
    //会错意版本
//        Arrays.sort(nums2);
//
//        res = new int[nums1.length];
//        for (int i =0;i< nums1.length;i++){
//            for (int j =0;j<nums2.length;j++){
//                if (nums2[j] > nums1[i]){
//                    res[i] = nums2[j];
//                    break;
//                }
//            }
//            res[i] = -1;
//        }

        //数组下标版本，适合数组中元素，连续且唯一的情况
//        res = new int[nums1.length];
//        int[] valueToIndex = new int[nums2.length];
//        for (int i = 0;i< nums2.length;i++){
//            valueToIndex[nums2[i]] = i;
//        }
//
//        int index = 0;
//        for (int i = 0;i<nums1.length;i++){
//            index = valueToIndex[nums1[i]];
//
//
//        }

        //思路1版本
//        int k;
//        res = new int[nums1.length];
//        for (int i =0;i<nums1.length;i++){
//            for (int j = 0;j<nums2.length;j++){
//                if (nums1[i] == nums2[j]){
//                    k = j;
//                    for (;k<nums2.length;k++){
//                        if (nums2[k] > nums1[i]){
//                            res[i] = nums2[k];
//                            break;
//                        }
//                    }
//                    if (k == nums2.length){
//                        res[i] = -1;
//                    }
//
//                }
//            }
//        }


        //思路2版本
        res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> tempMap =  new HashMap<>();

        for (Integer integer:nums2){
            while (!stack.isEmpty() && stack.peek() < integer){
                tempMap.put(stack.pop(),integer);
            }
            stack.push(integer);
        }

        for (int i =0;i<nums1.length;i++){
            res[i] = tempMap.getOrDefault(nums1[i],-1);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums1 = {4,2};
//        int[] nums2 = {1,2,3,4};

        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        solution(nums1,nums2);
    }
}
