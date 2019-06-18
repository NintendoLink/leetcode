/**
 * @Author: LinK
 * @Date: 2019/6/17 14:20
 */

package com.qhl.leetcode.array;

import java.util.Arrays;

/**
 * 561. 数组拆分 I
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。

 示例 1:

 输入: [1,4,3,2]

 输出: 4
 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 提示:

 n 是正整数,范围在 [1, 10000].
 数组中的元素范围在 [-10000, 10000].
 */
public class ArrayPairSumSolution {

    /**
     * 思路
     * 排序完之后，直接隔点取值即可(有严格的数学证明)
     * @param nums
     * @return
     */
    public static int solution(int[] nums){
        int result = 0;

        if (nums == null || nums.length ==0){
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0;i < nums.length;i+=2){
            result += nums[i];
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,2,4};
        System.out.println(solution(nums));
    }

}
