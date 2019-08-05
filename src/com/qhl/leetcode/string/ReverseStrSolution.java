/**
 * @Author: LinK
 * @Date: 2019/7/29 14:24
 */

package com.qhl.leetcode.string;

import java.util.Arrays;

/**
 * 541. 反转字符串 II
 *
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。

 示例:

 输入: s = "abcdefg", k = 2
 输出: "bacdfeg"
 要求:

 该字符串只包含小写的英文字母。
 给定字符串的长度和 k 在[1, 10000]范围内。
 */
public class ReverseStrSolution {

    /**
     *
     * abcdefg
     * bacdfeg
     * 思路
     * 1、非常麻烦的方法
     * @param s
     * @param k
     * @return
     */
    public static String solution(String s, int k) {
        if (s == null || s.length() ==0){
            return null;
        }

        StringBuffer tempSb = new StringBuffer();
        int start = 0;
        int end =2*k;
        for (;end<s.length();){
            char[] preChs = Arrays.copyOfRange(s.toCharArray(),start,start + k);

            tempSb.append(reverseStr(new String(preChs)));

            char[] nextChs = Arrays.copyOfRange(s.toCharArray(),start + k,end);
            String tempStr = new String(nextChs);
            tempSb.append(tempStr);

            start = end;
            end *= 2;
        }

        int jieduan = start + k > s.length() ? s.length() : start + k;

        char[] tempChs = Arrays.copyOfRange(s.toCharArray(),start,jieduan);

        tempSb.append(reverseStr(new String(tempChs)));

        if (jieduan < s.length()){

            tempSb.append(new String(Arrays.copyOfRange(s.toCharArray(),jieduan,s.length())));
        }
        return tempSb.toString();
    }

    private static String reverseStr(String str){

        char[] tempChs = new char[str.length()];
        for (int i = str.toCharArray().length-1;i>=0;i--){
            tempChs[str.length()-1-i] = str.toCharArray()[i];
        }
        return new String(tempChs);
    }

    /**
     * leetcode上非常简便的方法
     * 启发
     * 1、直接在charArray上操作，最后返回一个整体的charArray，不需要new 各种String
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char [] c=s.toCharArray();
        int len=c.length;
        for(int i=0;i<len; i=i+2*k){
            if(i+2*k<=len||i+k<=len){
                swap(c,i,i+k-1);
            }else{
                swap(c,i,len-1);
            }

        }
        return new String(c);
    }

    public static void swap(char [] a,int begin,int end){
        while(begin<end){
            a[begin]^=a[end];
            a[end]^=a[begin];
            a[begin]^=a[end];
            begin++;
            end--;
        }
    }

    /**
     * 照抄一遍
     * @param str
     * @param k
     * @return
     */
    public static String solution2(String str,int k){

        if (str == null || str.length()== 0){
            return null;
        }

        char[] chs = str.toCharArray();
        int len = str.length();
        for (int i =0;i<str.length();i+=2*k){
            if (i + 2* k <= len || i + k <=len ){
                charSwap(chs,i,i+k-1);
            }else {
                charSwap(chs,i,len-1);
            }
        }
        return new String(chs);

    }

    private static void charSwap(char[] chs,int begin,int end){

        while (begin < end){
            char temp = chs[begin];
            chs[begin] = chs[end];
            chs[end] = temp;

            begin ++;
            end--;
        }
    }


    public static void main(String[] args) {

        String str = "abc";
        System.out.println(solution(str,5));
    }
}
