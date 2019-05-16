/**
 * @Author: LinK
 * @Date: 2019/5/16 15:24
 */

package com.qhl.leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 169 .给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 示例 1:
 输入: [3,2,3]
 输出: 3

 示例 2:
 输入: [2,2,1,1,1,2,2]
 输出: 2
 */
public class MajorityElementSoultion {


    /**
     * 思路
     * 1、利用hashMap
     * 2、利用消去法
     * @param nums
     * @return
     */
    public static int solution(int[] nums){


        int count = 1;
        int index = nums[0];
        for (int i = 1;i<nums.length;i++){

            if (nums[i] == index){
                count++;
            }else {
                count--;
            }

            if (count==0){
                index = nums[i];
                count =1;
            }

        }
        return count >=0? index: 0;
//
//        Map<Integer,Integer> resMap = new HashMap<>();
//        for (Integer integer : nums){
//            if (resMap.containsKey(integer)){
//                resMap.put(integer,resMap.get(integer)+1);
//            }else {
//                resMap.put(integer,1);
//            }
//        }
//        for(Integer integer: resMap.keySet()){
//            if (resMap.get(integer) >= (nums.length+1)/2){
//
//                return integer;
//            }
//        }
//
//        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,2,1,12,2,1,1,21,1};

        System.out.println(solution(nums));
    }
}
