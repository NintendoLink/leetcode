/**
 * @Author: LinK
 * @Date: 2019/7/16 14:05
 */

package com.qhl.leetcode.array;

import java.util.Arrays;

/**
 *1089. 复写零
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。

 注意：请不要在超过该数组长度的位置写入元素。

 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。

  

 示例 1：

 输入：[1,0,2,3,0,4,5,0]
 输出：null
 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 示例 2：

 输入：[1,2,3]
 输出：null
 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 */
public class DuplicateZerosSolution {

    /**
     *思路
     * 1、直接移动 时间复杂度较高o(n2)，空间复杂度o(1)
     * @param arr
     */
    public static void solution(int[] arr){

        if (arr == null || arr.length==0){
            return;
        }

        for (int i = 0;i< arr.length;){

            if (arr[i] == 0){

                for (int j =arr.length-1;j >= i+2;j--){
                    arr[j] = arr[j-1];
                }
                if (i+1 < arr.length) {
                    arr[i+1] = 0;
                }
                i +=2;
            }else {
                i++;
            }
        }

        Arrays.stream(arr).boxed().forEach(integer -> System.out.println(integer));
    }

    public static void main(String[] args) {
//        int[] arr = {1,0,2,3,0,4,5,0};
//        int[] arr = {1,2,3};
        int[] arr = {0,0,0,0,0,0,0};
        solution(arr);
    }
}
