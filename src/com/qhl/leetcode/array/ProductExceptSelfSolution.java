/**
 * @Author: LinK
 * @Date: 2019/5/20 14:20
 */

package com.qhl.leetcode.array;


/**
 * 238. 除自身以外数组的乘积
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

 示例:

 输入: [1,2,3,4]
 输出: [24,12,8,6]
 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class ProductExceptSelfSolution {

    /**
     * 思路
     * 1、使用除法
     * 2、不使用除法
     *      从左到右乘一次，从右到左乘一次。
     *      即sums[i]应等于左边的乘积*右边的乘积;
     * @param nums
     * @return
     */
    public static int[] solution(int[] nums) {

        //思路1
//        int[] res = new int[nums.length];
//        if (nums == null || nums.length ==0){
//            return res;
//        }
//
//        int bigMulti = 1;
//        for (int i =0;i<nums.length;i++){
//            bigMulti *= nums[i];
//        }
//
//        for (int i =0;i<nums.length;i++){
//            res[i] = bigMulti / nums[i];
//        }
//
//        return res;

//        思路2
        int []sum=new int[nums.length];
        int left=1;
        for(int i=0;i<sum.length;i++)
        {
            sum[i]=left;
            left=left*nums[i];
        }
        int right=1;
        for(int i=sum.length-1;i>=0;i--)
        {
            sum[i]=sum[i]*right;
            right=right*nums[i];
        }
        return sum;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(solution(nums));
    }
}
