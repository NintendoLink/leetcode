/**
 * @Author: LinK
 * @Date: 2019/8/21 11:37
 */

package com.qhl.leetcode.string;

/**
 * 821. 字符的最短距离
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。

 示例 1:

 输入: S = "loveleetcode", C = 'e'
 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 说明:

 字符串 S 的长度范围为 [1, 10000]。
 C 是一个单字符，且保证是字符串 S 里的字符。
 S 和 C 中的所有字母均为小写字母。

 */
public class ShortestToCharSolution {

    /**
     * 思路
     * 1、左右指针循环即可
     * @param S
     * @param C
     * @return
     */
    public static int[] solution(String S,char C){

        int[] res = new int[S.length()];

        if (S ==  null || S.length() == 0){
            return res;
        }

        char[] chs = S.toCharArray();
        for (int i =0;i<res.length;i++){
            res[i] = chs.length;
        }
        for (int i =0;i< chs.length;i++){

            if (chs[i] == C){
                res[i] = 0;
                continue;
            }
            int leftDis = 0;
            int rightDis = 0;

            int left = i;
            int right = i;
            for (;left >= 0;left--){
                if (chs[left] == C){
                    break;
                }
                leftDis++;
            }
            res[i] = left ==-1? res[i]:leftDis;
            for (;right<chs.length;right++){
                if (chs[right] == C){
                    break;
                }
                rightDis++;
            }
            if (right != chs.length){
                res[i] = res[i] < rightDis? res[i] :rightDis;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        char C = 'e';

        solution(s,C);
    }
}
