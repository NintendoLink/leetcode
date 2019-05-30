/**
 * @Author: LinK
 * @Date: 2019/5/30 10:25
 */

package com.qhl.leetcode.string;

/**
 * 14. 最长公共前缀（*）
 * 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 */
public class LongestCommonPrefixSolution {

    /**
     * 思路
     * 1、暴力循环算法
     * @param strs
     * @return
     */
    public static String solution(String[] strs){
        if (strs == null || strs.length ==0){
            return "";
        }

        StringBuilder sb = new StringBuilder("");

        char[] chs = strs[0].toCharArray();
        for (int i =0;i<chs.length;i++){
            boolean flag = true;

            for (String str : strs){
                try {
                    if (str.toCharArray()[i] != chs[i]){
                        flag = false;
                    }
                } catch (Exception e) {
                    return sb.toString();
                }
            }

            if (flag){
                sb.append(chs[i]);
            }else {
                return sb.toString();
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"aca","cba"};
        System.out.println(solution(strs));
    }
}
