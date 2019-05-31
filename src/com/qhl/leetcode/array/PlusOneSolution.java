/**
 * @Author: LinK
 * @Date: 2019/5/31 10:43
 */

package com.qhl.leetcode.array;

import java.util.Arrays;

/**
 * 66. 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:

 输入: [1,2,3]
 输出: [1,2,4]
 解释: 输入数组表示数字 123。
 示例 2:

 输入: [4,3,2,1]
 输出: [4,3,2,2]
 解释: 输入数组表示数字 4321。
 */
public class PlusOneSolution {

    /**
     * 思路：
     * 1、可以转换成整数(int或者long)，不过当给出的数组lenth很大时，long也盛不下
     * 2、递归算法
     * @param digits
     * @return
     */
    public static int[] solution(int[] digits){

        if (digits == null || digits.length ==0){
            return digits;
        }

        return plusOne(digits,digits.length-1);

    }

    private static int[] plusOne(int[] digits, int index) {

        if (index < 0){
            digits = new int[digits.length+1];
            digits[0] = 1;
//            Arrays.stream(digits).boxed().forEach(integer -> System.out.println(integer));
            return digits;
        }

        digits[index]+=1;
        if (digits[index] > 9){
            digits[index] = 0;
            return plusOne(digits,index-1);
        }

//        Arrays.stream(digits).boxed().forEach(integer -> System.out.println(integer));
        return digits;
    }


    private static int[] number2Array(long num) {

        long tempNum = num;
        int tempCount = 0;
        while (tempNum > 0){
            tempCount++;
            tempNum /= 10;
        }

        int[] res = new int[tempCount];

        long tempLevel;

        for (int i = 0;i <tempCount; i++){

            tempLevel = (int) Math.pow(10,tempCount - 1 -i);
            res[i] = (int) ( num / tempLevel);
            num %= tempLevel;
        }

        Arrays.stream(res).boxed().forEach(integer -> System.out.println(integer));
        return res;
    }

    private static long array2Number(int[] digits) {

        long res = 0;
        for (int i = digits.length-1;i >= 0;i--){
            res += digits[i] * (long)Math.pow(10,digits.length-1-i);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] digits = {9};
        Arrays.stream(solution(digits)).boxed().forEach(integer -> System.out.println(integer));
//        solution(digits);
    }
}
