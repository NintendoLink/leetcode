/**
 * @Author: LinK
 * @Date: 2019/5/30 14:10
 */

package com.qhl.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 26. 删除排序数组中的重复项(*)
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

 示例 1:

 给定数组 nums = [1,1,2],

 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

 你不需要考虑数组中超出新长度后面的元素。
 示例 2:

 给定 nums = [0,0,1,1,1,2,2,3,3,4],

 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicatesSolution {

    /**
     * 思路
     * 1、利用TReeset（需要额外空间，本地运行通过，平台未通过）
     * 2、利用填坑法，未通过----题目中有隐形要求，要求不重复的数字也是排序好的
     * 3、利用双指针法
     * @param nums
     * @return
     */
    public static int solution(int[] nums){

        if (nums == null || nums.length ==0){
            return 0;
        }

//        Set<Integer> resSet = new TreeSet<>();
//        for (Integer integer: nums){
//            resSet.add(integer);
//        }
//        nums = new int[resSet.size()];
//
//        int index = 0;
//        for (Integer integer: resSet){
//            nums[index++] = integer;
//        }
//        Arrays.stream(nums).boxed().forEach(integer -> System.out.println(integer));
//        return resSet.size();


//        for (int i = 0;i<nums.length-1;i++){
//            if (nums[i] == nums[i+1]){
//                nums[i] = -1;
//            }
//        }
//
//        int head = 0;
//        int tail = nums.length-1;
//
//        while (head < tail){
//            int temp;
//            while (head < tail && nums[head] > -1){
//                head++;
//            }
//
//            while (head < tail && nums[tail] == -1){
//                tail--;
//            }
//
//            temp = nums[head];
//            nums[head] = nums[tail];
//            nums[tail] = temp;
//        }
//        return head;

//        Arrays.stream(nums).boxed().forEach(integer -> System.out.println(integer));

        int numSize = 1;
        int past = 0;
        int cur =1;

        while (cur< nums.length){
            if (nums[past] != nums[cur]){
                past++;
                numSize++;
                nums[past] = nums[cur];
            }
            cur++;
        }

//        Arrays.stream(nums).boxed().forEach(integer -> System.out.println(integer));
        return numSize;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
//        int[] nums = {1,1,2};
        System.out.println(solution(nums));
//        solution(nums);
    }
}
