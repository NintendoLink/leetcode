/**
 * @Author: LinK
 * @Date: 2019/7/23 14:10
 */

package com.qhl.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRelativeRanksSolution {
    public static String[] solution(int[] nums) {

        if (nums == null || nums.length == 0){
            return null;
        }

        int[] numsCopy = new int[nums.length];

        numsCopy = Arrays.copyOfRange(nums,0,nums.length);
        String[] resStr = new String[nums.length];
        Map<Integer,Integer> tempMap = new HashMap<>();

        for (int i =0;i<nums.length;i++){

            tempMap.put(nums[i],i);

        }

        Arrays.sort(numsCopy);

        for (int i =0;i<numsCopy.length-3;i++){

            resStr[tempMap.get(numsCopy[i])] = String.valueOf(nums.length-i);
        }

        resStr[tempMap.get(numsCopy[numsCopy.length-3])] = "Bronze Medal";
        resStr[tempMap.get(numsCopy[numsCopy.length-2])] = "Silver Medal";
        resStr[tempMap.get(numsCopy[numsCopy.length-1])] = "Gold Medal";
        return resStr;
    }

    public static void main(String[] args) {

//        int[] nums = {6,5, 4, 3,9,8, 2, 1};
        int[] nums = {5, 4, 3, 2, 1};

        solution(nums);
//        Arrays.sort(nums);
//        Arrays.stream(nums).boxed().forEach(integer -> System.out.println(integer));
    }
}
