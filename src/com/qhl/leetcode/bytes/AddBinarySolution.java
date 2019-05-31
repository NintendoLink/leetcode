/**
 * @Author: LinK
 * @Date: 2019/5/31 14:44
 */

package com.qhl.leetcode.bytes;

import java.util.Arrays;
import java.util.Stack;

/**
 * 3、67. 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。

 输入为非空字符串且只包含数字 1 和 0。

 示例 1:

 输入: a = "11", b = "1"
 输出: "100"
 示例 2:

 输入: a = "1010", b = "1011"
 输出: "10101"
 */
public class AddBinarySolution {

    /**
     * 思路
     * 1、转数字，结果被n长的字符串暴击(此路不通)
     * 2、常规方法，n多的三模运算符
     * @param a
     * @param b
     * @return
     */
    public static String solution(String a,String b){

//        int numOne = string2Num(a);
//        int numTwo = string2Num(b);
//
//        int resNum = numOne + numTwo;

        char[] chsOne = a.toCharArray();
        char[] chsTwo = b.toCharArray();

        return chsOne.length > chsTwo.length ? addBinary(chsOne,chsTwo) : addBinary(chsTwo,chsOne);
    }

    private static String addBinary(char[] chsOne, char[] chsTwo) {

        char[] tempChs = new char[chsOne.length];

        for (int i =0;i <tempChs.length;i++){

            tempChs[i] = tempChs.length - i > chsTwo.length ? '0' : chsTwo[i- chsOne.length + chsTwo.length];

        }
        char[] resChs = new char[chsOne.length+1];

        int tempVal;
        int flag = 0;
        for (int i = resChs.length-1; i>=0;i--){
                tempVal = i != 0 ? chsOne[i-1] + tempChs[i-1] - (48 * 2) + flag : flag;
                resChs[i] = (char)((tempVal > 1 ? tempVal >2 ? 1:0 : tempVal) + 48);
                flag = tempVal > 1 ? 1 : 0;
        }

        if (resChs[0] == '0'){
            return new String(Arrays.copyOfRange(resChs,1,resChs.length));
        }

        return new String(resChs);
    }

    private static String num2String(int resNum) {

        if (resNum == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder("");

        Stack<String> tempStack = new Stack<>();
        int temp = 1;
        while (resNum != 0){
            tempStack.push(String.valueOf(temp & resNum));
            resNum >>>= 1;
        }

        while (!tempStack.isEmpty()){
            sb.append(tempStack.pop());
        }
        return sb.toString();
    }

    private static int string2Num(String a) {
        char[] chs = a.toCharArray();

        int level = 0;
        int res = 0;
        for (int i = chs.length-1;i>=0;i--){
            res += Math.pow(2,level++) * (chs[i] == '1' ? 1 : 0);
        }
        return res;
    }

    public static void main(String[] args) {

        String a = "11";
        String b = "1";

        System.out.println(solution(b,a));
    }
}
