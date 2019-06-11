/**
 * @Author: LinK
 * @Date: 2019/6/11 15:54
 */

package com.qhl.leetcode.array;

/**
 * 485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。

 示例 1:

 输入: [1,1,0,1,1,1]
 输出: 3
 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 注意：

 输入的数组只包含 0 和1。
 输入数组的长度是正整数，且不超过 10,000。
 在真实的面试中遇到过这道题？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMaxConsecutiveOnesSolution {

    /**
     * 思路
     * 1、循环遍历即可
     * @param nums
     * @return
     */
    public static int solution(int[] nums){

        int result = 0;
        if (nums == null || nums.length ==0){
            return result;
        }

        int count = 0;
        for (int i = 0;i< nums.length;i++){
            if (nums[i] == 1){
                count ++;
            }else {
                result = result > count ? result : count;
                count =0;
            }
        }
        result = result > count ? result : count;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1,1};

        System.out.println(solution(nums));
    }
}
