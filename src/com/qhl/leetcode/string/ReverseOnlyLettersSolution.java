/**
 * @Author: LinK
 * @Date: 2019/7/22 10:24
 */

package com.qhl.leetcode.string;

/**
 * 917. 仅仅反转字母
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。

  

 示例 1：

 输入："ab-cd"
 输出："dc-ba"
 示例 2：

 输入："a-bC-dEf-ghIj"
 输出："j-Ih-gfE-dCba"
 示例 3：

 输入："Test1ng-Leet=code-Q!"
 输出："Qedo1ct-eeLg=ntse-T!"
  

 提示：

 S.length <= 100
 33 <= S[i].ASCIIcode <= 122 
 S 中不包含 \ or "

 */
public class ReverseOnlyLettersSolution {

    /**
     * 思路
     * 1、双指针遍历法即可
     * @param S
     * @return
     */
    public static String solution(String S) {

        char[] chs = S.toCharArray();
        int i = 0;
        int j = chs.length-1;

        while (i<j){
            while ((i<j) && (chs[i] <65 || chs[i] > 122 || (chs[i] >90 && chs[i] <97))){
                i++;
            }

            while ((i<j) && (chs[j] <65 || chs[j] > 122 || (chs[j] >90 && chs[j] <97))){
                j--;
            }

            if (i<j){
                char temp = chs[i];
                chs[i] = chs[j];
                chs[j] = temp;

                i++;
                j--;
            }
        }

        return new String(chs);
    }

    public static void main(String[] args) {
        System.out.println(solution("Test1ng-Leet=code-Q!"));
    }
}
