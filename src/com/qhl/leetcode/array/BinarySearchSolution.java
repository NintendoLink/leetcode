/**
 * @Author: LinK
 * @Date: 2019/6/17 14:29
 */

package com.qhl.leetcode.array;

/**
 * 704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。


 示例 1:

 输入: nums = [-1,0,3,5,9,12], target = 9
 输出: 4
 解释: 9 出现在 nums 中并且下标为 4
 示例 2:

 输入: nums = [-1,0,3,5,9,12], target = 2
 输出: -1
 解释: 2 不存在 nums 中因此返回 -1
 */
public class BinarySearchSolution {

    /**
     * 思路
     * 常规算法，注意边界情况。
     * @param nums
     * @param target
     * @return
     */
    public static int solution(int[] nums,int target){

        if (nums == null || nums.length ==0){
            return -1;
        }

        int low = 0;
        int high = nums.length-1;
        int mid;
        while (low <= high){
            mid = (low + high) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,6,7,8,9,10,11};
        int target = 10;

        System.out.println(solution(nums,target));
    }
}
