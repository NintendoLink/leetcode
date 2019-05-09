/**
 * @Author: LinK
 * @Date: 2019/5/9 9:32
 */

package com.qhl.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * no1:两数之和的问题
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSumSolution {

    /**
     * 思路
     * 1：暴解法
     * 2：利用哈希可以直接以o（1）的时间复杂度直接定位元素，然后转换成查找问题
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution(int[] nums,int target){

        if (nums == null || nums.length ==0){
            return null;
        }

        int[] res = new int[2];

        //暴力解法
//        for (int i =0;i<nums.length;i++){
//            for (int j = i+1;j<nums.length;j++){
//
//                if (nums[i] + nums[j] == target){
//                    res[0] = i;
//                    res[1] = j;
//                    break;
//                }
//            }
//        }

        //哈希法
        Map<Integer,Integer> map = new HashMap<>();

        for (int i =0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for (int i = 0;i<nums.length;i++){
            int complement = target-nums[i];

            if (map.containsKey(complement) && map.get(complement)!=i){

                return new int[]{i,map.get(complement)};
            }
        }

        return res;

    }

    public static void main(String[] args) {

        int[] array = {3,3};
        System.out.println(solution(array,6));
//
//        System.out.println();

    }
}
