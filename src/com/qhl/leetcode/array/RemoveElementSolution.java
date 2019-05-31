/**
 * @Author: LinK
 * @Date: 2019/5/31 10:20
 */

package com.qhl.leetcode.array;

import java.util.Arrays;

/**
 * 27. 移除元素
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

 示例 1:

 给定 nums = [3,2,2,3], val = 3,

 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

 你不需要考虑数组中超出新长度后面的元素。
 示例 2:

 给定 nums = [0,1,2,2,3,0,4,2], val = 2,

 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

 注意这五个元素可为任意顺序。

 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElementSolution {

    /**
     * 思路
     * 双指针算法
     * @param nums
     * @param val
     * @return
     */
    public static int solution(int[] nums,int val){

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int head = 0;
        int tail = nums.length-1;

        while (head <= tail){
            while (head <= tail && nums[head] != val){
                head++;
            }

            while (head <= tail && nums[tail] == val){
                tail--;
            }

            if (head <= tail){
                nums[head++] = nums[tail--];
            }
        }
        Arrays.stream(nums).boxed().forEach(integer -> System.out.println(integer));
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        solution(nums,2);
//        System.out.println(solution(nums,2));
    }
}
