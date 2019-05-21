/**
 * @Author: LinK
 * @Date: 2019/5/20 10:10
 */

package com.qhl.leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *  示例 1:

 输入: J = "aA", S = "aAAbbbb"
 输出: 3
 示例 2:

 输入: J = "z", S = "ZZ"
 输出: 0
 注意:

 S 和 J 最多含有50个字母。
 J 中的字符不重复。
 */
public class NumJewelsInStonesSolution {

    /**
     * 思路：
     * 1、简单的哈希即可
     * @param S
     * @param J
     * @return
     */
    public static int solution(String S,String J){

        int count =0;

        if (S == null || S.length() ==0 ||
                J == null || J.length() ==0){
            return count;
        }


        Map<Character,Integer> stoneCategory =  new HashMap<>();

        for (Character ch : J.toCharArray()){
            stoneCategory.put(ch,1);
        }

        for (Character ch: S.toCharArray()){
            if (stoneCategory.containsKey(ch)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String S = "ZZ";
        String J = "z";

        System.out.println(solution(S,J));
    }
}
