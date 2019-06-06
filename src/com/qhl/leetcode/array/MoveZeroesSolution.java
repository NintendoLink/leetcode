/**
 * @Author: LinK
 * @Date: 2019/6/6 14:00
 */

package com.qhl.leetcode.array;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 示例:

 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 说明:

 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。
 */
public class MoveZeroesSolution {

    /**
     * 思路
     * 1、前后指针
     *  tips：要注意前指针的index值不能大于后指针的index，如果大于，则要把后指针移动的前指针之后，由此来保持“序”
     * 2、    //思路：设置一个index，表示非0数的个数，循环遍历数组，
            // 如果不是0，将非0值移动到第index位置,然后index + 1
            //遍历结束之后，index值表示为非0的个数，再次遍历，从index位置后的位置此时都应该为0
     * @param nums
     */
    public static void solution(int[] nums){

        if (nums == null || nums.length ==0){
            return;
        }
//        {4,2,4,0,0,3,0,5,1,0}
        //思路1
//        int zeroIndex = 0;
//        int nonZeroIndex = 1;
//
//        while (zeroIndex < nums.length && nonZeroIndex <nums.length){
//
//            while (zeroIndex < nums.length && nums[zeroIndex] != 0){
//                zeroIndex ++;
//            }
//
//            while (nonZeroIndex <nums.length && nums[nonZeroIndex] == 0){
//                nonZeroIndex ++;
//            }
//
//            if (zeroIndex < nonZeroIndex){
//                if (zeroIndex < nums.length && nonZeroIndex <nums.length){
//
//                    int temp = nums[zeroIndex];
//                    nums[zeroIndex] = nums[nonZeroIndex];
//                    nums[nonZeroIndex] = temp;
//                }
//            }else {
//                nonZeroIndex = zeroIndex;
//            }
//
//        }

        //思路2
        int index = 0;
        for (int i =0;i<nums.length;i++){
            if (nums[i] !=0){
                nums[index] = nums[i];
                index++;
            }
        }

        for (;index<nums.length;index++){
            nums[index] =0;
        }

        Arrays.stream(nums).boxed().collect(Collectors.toList()).forEach(integer -> System.out.println(integer));
    }

    public static void main(String[] args) {

        int[] nums = {4,2,4,0,0,3,0,5,1,0};
        solution(nums);
    }
}
