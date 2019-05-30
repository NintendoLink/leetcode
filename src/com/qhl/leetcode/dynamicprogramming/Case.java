/**
 * @Author: LinK
 * @Date: 2019/5/30 10:57
 */

package com.qhl.leetcode.dynamicprogramming;

public class Case {

    public static void main(String[] args) {

        int[] nums = new int[15];
        nums[0] = 0;
        int cost = 9999;
        for (int i = 0;i<15;i++){
            if (i-1 >= 0){
                cost = Math.min(cost,nums[i-1] + 1);
            }
            if (i-5 >=0){
                cost = Math.min(cost,nums[i-5] + 1);
            }
            if (i-11 >=0){
                cost = Math.min(cost,nums[i-11] + 1);
            }
            nums[i] = cost;
            System.out.println(cost);
        }
    }
}
