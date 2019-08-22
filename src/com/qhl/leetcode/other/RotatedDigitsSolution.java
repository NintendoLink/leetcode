/**
 * @Author: LinK
 * @Date: 2019/8/22 16:05
 */

package com.qhl.leetcode.other;

/**
 * 788. 旋转数字
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。

 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。

 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？

 示例:
 输入: 10
 输出: 4
 解释:
 在[1, 10]中有四个好数： 2, 5, 6, 9。
 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 注意:

 N 的取值范围是 [1, 10000]。

 */
public class RotatedDigitsSolution {

    /**
     * 思路
     * 1、直接比较
     * 2、每位都在(2, 5, 6, 9, 0, 1, 8)内，至少一位在(2, 5, 6, 9)内
     * @param N
     * @return
     */
    public static int solution(int N) {


        int res = 0;

        //思路1 不知为何错误
//        for (int i = 1;i<=N;i++){
//            res += isRotate(i)? 1:0;
////            if (isRotate(i)){
////                System.out.println(i);
////            }
//        }

        for (int i = 2; i <= N; i++) {
            String s = String.valueOf(i);
            s = s.replaceAll("[+0,+1,+8]", "");
            if (!"".equals(s)) {
                s = s.replaceAll("[+2,+5,+6,+9]", "");
                if ("".equals(s)) {
                    res += 1;
                }
            }
        }
        return res;
    }

    private static boolean isRotate(int i) {

        char[] numberToChar = String.valueOf(i).toCharArray();
        int start = 0;
        int end = numberToChar.length-1;

        while (start <= end){
            if (singleCharRotate(numberToChar[start]) == 'a' ||
                    singleCharRotate(numberToChar[end]) =='a' ||
                    singleCharRotate(numberToChar[start]) == numberToChar[start]||
                    singleCharRotate(numberToChar[end]) == numberToChar[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static char singleCharRotate(char ch){
        if (ch == '0' || ch =='1' || ch =='8'){
            return ch;
        }
        if (ch == '2' || ch =='5'){
            return (ch =='2' ? '5' :'2');
        }

        if (ch == '6' || ch == '9'){
            return ch == '6' ? '9' : '6';

        }
        return 'a';
    }
    public static void main(String[] args) {

//        System.out.println(isRotate(7));
        System.out.println(solution(10));
    }
}
