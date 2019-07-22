/**
 * @Author: LinK
 * @Date: 2019/7/22 10:56
 */

package com.qhl.leetcode.array;

/**
 * 268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

 示例 1:

 输入: [3,0,1]
 输出: 2
 示例 2:

 输入: [9,6,4,2,3,5,7,0,1]
 输出: 8
 */
public class MissingNumberSolution {

    /**
     * 思路
     * 1、开辟额外新数组，用数组下标记录出现的值，速度慢，并且需要额外存储空间
     * 2、直接计算
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {

        if (nums == null || nums.length ==0){
            return 0;
        }

//        思路2
        int sum = 0;
        for (int i =0;i<nums.length;i++){
            sum += nums[i];
        }

        int len = nums.length;
        return (len * (len+1) / 2) - sum;

//        思路1
//        int[] resArr = new int[nums.length+1];
//
//        for (int i =0;i<nums.length;i++){
//            resArr[nums[i]] = 1;
//        }
//
//        for (int i = 0;i<resArr.length;i++){
//            if (resArr[i] ==0){
//                return i;
//            }
//        }
//        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(solution(nums));
    }
}
