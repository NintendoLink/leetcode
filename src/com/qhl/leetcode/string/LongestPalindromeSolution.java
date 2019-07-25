/**
 * @Author: LinK
 * @Date: 2019/7/25 15:41
 */

package com.qhl.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

 注意:
 假设字符串的长度不会超过 1010。

 示例 1:

 输入:
 "abccccdd"

 输出:
 7

 解释:
 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LongestPalindromeSolution {

    /**
     * 思路
     * 1、简单的哈希即可
     * 2、用数组代替哈希
     * @param s
     * @return
     */
    public static int solution(String s) {

        if (s == null || s.length() ==0){
            return 0;
        }

        int res = 0;
        Map<Character,Integer> tempMap = new HashMap<>();

        for (char ch : s.toCharArray()){
            tempMap.put(ch,tempMap.containsKey(ch) ? tempMap.get(ch)+1:1);
        }


        for (char ch : tempMap.keySet()){
            if (tempMap.get(ch) > 1){
                res += (tempMap.get(ch)/2) * 2;
            }
        }
        return res == s.length() ? res : res+1;
    }

    public static void main(String[] args) {
        System.out.println(solution("ababababa"));
    }
}
