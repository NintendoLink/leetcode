/**
 * @Author: LinK
 * @Date: 2019/6/19 9:52
 */

package com.qhl.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。

 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

 示例 1:

 输入: [1, 2, 2, 3, 1]
 输出: 2
 解释:
 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 连续子数组里面拥有相同度的有如下所示:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 最短连续子数组[2, 2]的长度为2，所以返回2.
 示例 2:

 输入: [1,2,2,3,1,4,2]
 输出: 6
 */
public class FindShortestSubArraySolution {

    /**
     * 思路
     * 1、最原始的方法 hash（key，count）,注意，频数相同的key不止有一个，因此，频数相同的key要放在List当中，取所有满足条件的最短连续子数组
     * @param nums
     * @return
     */
    public static int solution(int[] nums){

        int result = 0;
        if (nums == null || nums.length ==0){
            return result;
        }

        Map<Integer,Integer> tempMap = new HashMap<>();

        for (int i = 0;i<nums.length;i++){

            tempMap.put(nums[i],tempMap.containsKey(nums[i]) ? tempMap.get(nums[i]) + 1 : 1);
        }

        //key为频数相同的键的频数，值为键的集合。
        Map<Integer,List<Integer>> valueMap = new HashMap<>();

        for (Integer key : tempMap.keySet()){
            if (valueMap.isEmpty()){
                List<Integer> tempList = new ArrayList<>();
                tempList.add(key);
                valueMap.put(tempMap.get(key),tempList);
            }else if ((int)valueMap.keySet().toArray()[0] == tempMap.get(key)){
                valueMap.get(valueMap.keySet().toArray()[0]).add(key);
            }else if ((int)valueMap.keySet().toArray()[0] < tempMap.get(key)){
                valueMap.remove(valueMap.keySet().toArray()[0]);
                List<Integer> tempList = new ArrayList<>();
                tempList.add(key);
                valueMap.put(tempMap.get(key),tempList);
            }
        }

        //valueMap.get(valueMap.keySet().toArray()[0])

        for (Integer key : valueMap.get(valueMap.keySet().toArray()[0])) {
            int start =0;
            int end = nums.length-1;
            while (nums[start++] != key);
            while (nums[end--] != key);

            result = result == 0 ? end - start + 3 : (result < end - start + 3 ? result : end - start + 3);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4,2};
        System.out.println(solution(nums));
    }


//    class Solution {
//        public int findShortestSubArray(int[] nums) {
//            int n = nums.length;
//            int[] freq = new int[50000];
//            int max = 0;
//            Set<Integer> set = new HashSet<>();
//            for(int i = 0;i < n;i++){
//                freq[nums[i]]++;
//                if(freq[nums[i]] > max){
//                    set.clear();
//                    set.add(nums[i]);
//                    max = freq[nums[i]];
//                }
//                if(freq[nums[i]] == max)
//                    set.add(nums[i]);
//            }
//            int res = n;
//
//            for(Integer i : set){
//                int tmp = i;
//                int p1 = 0,p2 = n - 1;
//                while(p1 <= p2){
//                    while(p1 < p2 && nums[p1] != tmp) p1++;
//                    while(p1 < p2 && nums[p2] != tmp) p2--;
//                    res = Math.min(res,p2-p1+1);
//                    break;
//                }
//            }
//            return res;
//        }
//    }
}
