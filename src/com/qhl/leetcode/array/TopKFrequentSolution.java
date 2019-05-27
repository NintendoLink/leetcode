/**
 * @Author: LinK
 * @Date: 2019/5/27 10:19
 */

package com.qhl.leetcode.array;

import java.util.*;

/**
 * 347. 前K个高频元素
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 示例 1:

 输入: nums = [1,1,1,2,2,3], k = 2
 输出: [1,2]
 示例 2:

 输入: nums = [1], k = 1
 输出: [1]
 */
public class TopKFrequentSolution {


    /**
     * 思路
     * 1、使用优先队列
     * 2、尝试使用堆来解决
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> solution(int[] nums, int k){


        List<Integer> resList = new ArrayList<>();
        if (nums == null || nums.length == 0||
                k>nums.length){
            return resList;
        }

        Map<Integer,Integer> freqMap = new HashMap<>();

        for (int i = 0;i< nums.length;i++){
            freqMap.put(nums[i],freqMap.containsKey(nums[i])? freqMap.get(nums[i])+1:1);
        }


        //思路1:优先队列
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return freqMap.get(o1) - freqMap.get(o2);
            }
        });

        for (Integer key: freqMap.keySet()){
            if (pq.size()<k){
                pq.add(key);
            }else if (freqMap.get(key) > freqMap.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }

        while (!pq.isEmpty()){
            resList.add(pq.remove());
        }
        return resList;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        solution(nums,1).forEach(integer -> System.out.println(integer));
    }
}
