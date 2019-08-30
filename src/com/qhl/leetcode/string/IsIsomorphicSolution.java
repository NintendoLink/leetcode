/**
 * @Author: LinK
 * @Date: 2019/8/30 10:06
 */

package com.qhl.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。

 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

 示例 1:

 输入: s = "egg", t = "add"
 输出: true
 示例 2:

 输入: s = "foo", t = "bar"
 输出: false
 示例 3:

 输入: s = "paper", t = "title"
 输出: true
 说明:
 你可以假设 s 和 t 具有相同的长度。
 */
public class IsIsomorphicSolution {

    /**
     * 思路
     * 1、java 通过map的 k-v 解决
     * 2、可以通过优化的数组解决
     * @param s
     * @param t
     * @return
     */
    public static boolean solution(String s, String t) {

        if (s == null || t == null ||
                s.length() != t.length()){
            return  false;
        }

        char[] sChs = s.toCharArray();
        char[] tChs = t.toCharArray();
        Map<Character,Character> tempMap = new HashMap<>();
        Map<Character,Character> veryfyOnlyKeyMap = new HashMap<>();
        for (int i = 0;i<sChs.length;i++){
//            if (sChs[i] != tChs[i]) {
//                if (!tempMap.keySet().contains(sChs[i])) {
//                    tempMap.put(sChs[i], tChs[i]);
//                }else {
//                    if (tempMap.get(sChs[i]) != tChs[i]){
//                        return false;
//                    }
//                }
//            }
            if (!tempMap.keySet().contains(sChs[i])) {
                if (veryfyOnlyKeyMap.keySet().contains(tChs[i]) && veryfyOnlyKeyMap.get(tChs[i]) != sChs[i]){
                    return false;
                }
                tempMap.put(sChs[i], tChs[i]);
                veryfyOnlyKeyMap.put(tChs[i],sChs[i]);
            }else {
                if (tempMap.get(sChs[i]) != tChs[i]){
                    return false;
                }
            }
        }

        return true;
    }

    //ab aa false
    public static void main(String[] args) {
        String s = "agg";
        String t = "foo";

        System.out.println(solution(s,t));
    }
}
