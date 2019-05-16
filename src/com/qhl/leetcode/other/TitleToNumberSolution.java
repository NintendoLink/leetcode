/**
 * @Author: LinK
 * @Date: 2019/5/16 16:14
 */

package com.qhl.leetcode.other;

/**
 * 171. Excel表列序号
 */
public class TitleToNumberSolution {

    /**
     * 简单的26进制问题
     * @param s
     * @return
     */
    public static int solutio(String s){

        int res = 0;
        int jieshu = 1;
        char[] chs = s.toCharArray();
        for (int i = chs.length-1;i>=0;i--){

            res += (chs[i] - 'A' + 1) * jieshu;
            jieshu *= 26;
        }
        return res;
    }

    public static void main(String[] args) {

        String s ="ZY";
        System.out.println(solutio(s));

    }
}
