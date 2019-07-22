/**
 * @Author: LinK
 * @Date: 2019/7/18 17:15
 */

package com.qhl.leetcode.array;


/**
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。

 示例 1:

 输入: [1,12,-5,-6,50,3], k = 4
 输出: 12.75
 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
  

 注意:

 1 <= k <= n <= 30,000。
 所给数据范围 [-10,000，10,000]。
 */
public class FindMaxAverageSolution {

    /**
     * 思路
     * 1、滑动窗口算法，注意不要累加，会超时，利用加减算法即可
     * @param nums
     * @param k
     * @return
     */
    public static double solution(int[] nums,int k){

        double res = 0;
        if (nums == null ||
                nums.length < k){
            return res;
        }

        double temp = 0.0;
        for (int i = 0;i<k;i++){
            res += nums[i];
        }

        temp = res;
        for (int i=0,j=k;j<nums.length;i++,j++){
            if (temp + nums[j] - nums[i] > res){
                res = temp + nums[j] - nums[i];
                temp = temp + nums[j] - nums[i];
            }else {
                temp = temp + nums[j] - nums[i];
            }
        }

        return res / k;
//        for (int i =0;i<=nums.length -k;i++){
//
//            double temp = 0;
//            for (int j = 0;j<k;j++){
//                temp += nums[i+j];
//            }
//
//            if (i == 0){
//                res = temp/k;
//                continue;
//            }
//            res = res > temp/k ? res : temp/k;
//        }
//        return res;
    }

    public static void main(String[] args) {

//        int[] nums = {1,12,-5,-6,50,3};
//        int[] nums = {-1};
        int[] nums = {0,1,1,3,3};
        System.out.println(solution(nums,2));
    }
}
