/**
 * @Author: LinK
 * @Date: 2019/6/18 16:08
 */

package com.qhl.leetcode.dynamicprogramming;

/**
 * 最长公共子序列问题(LongestCommonSequence)
 * 动态规划两个特点
 * 1、最有子结构
 *      问题可以分解为若干个小问题，并且每一个小问题的解法与原问题相同
 * 2、重复自问题
 *      每个小问题中的解，有重合的部分
 * https://blog.csdn.net/someone_and_anyone/article/details/81044153
 */

public class LongestCommonSequenceSolution {

    public static int solution(String s1,String s2){

        if (s1 == null || s2 == null ||
                s1.length() ==0 || s2.length() ==0){
            return 0;
        }

        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i =1;i<dp.length;i++){

            for (int j =1;j<dp[i].length;j++){
//                if (chs1[i-1] == chs2[j-1]){
//                    dp[i][j] = dp[i-1][j-1] + 1;
//                }else {
//                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
//                }
                dp[i][j] = chs1[i-1] == chs2[j-1] ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1= "ABCDoeBAT";
        String s2 = "BDeBTA";
        System.out.println(solution(s1,s2));
    }
}
