/**
 * @Author: LinK
 * @Date: 2019/7/22 11:18
 */

package com.qhl.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 136. 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

 说明：

 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

 示例 1:

 输入: [2,2,1]
 输出: 1
 示例 2:

 输入: [4,1,2,1,2]
 输出: 4
 */
public class SingleNumberSolution {

    /**
     * 思路
     * 1、使用HashMap记录出现的次数，或者用数组也可以，需要额外的存储空间
     * 2、使用异或运算，基于以下异或的性质
     *      任何数与0做运算等于其本身
     *      自身与自身异或等于0
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        if (nums == null || nums.length ==0){
            return 0;
        }

//        思路2
        int res = 0;
        for (Integer num : nums){
            res = res ^ num;
        }
        return res;

//        思路1
//        Map<Integer,Integer> resMap = new HashMap<>();
//
//        for (Integer num: nums){
//            resMap.put(num,resMap.containsKey(num) ? resMap.get(num) + 1 : 1);
//        }
//
//        for (Integer num : resMap.keySet()){
//            if (resMap.get(num) ==1){
//                return num;
//            }
//        }
//        return 0;
    }

    public static void main(String[] args) {

        int[] nums = {2,2,1};

        System.out.println(solution(nums));
    }
}
