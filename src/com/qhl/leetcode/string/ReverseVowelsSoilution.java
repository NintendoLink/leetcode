/**
 * @Author: LinK
 * @Date: 2019/5/27 9:39
 */

package com.qhl.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

 示例 1:

 输入: "hello"
 输出: "holle"
 示例 2:

 输入: "leetcode"
 输出: "leotcede"
 说明:
 元音字母不包含字母"y"。
 */
public class ReverseVowelsSoilution {
    /**
     * 思路
     * 常规思路即可
     * @param s
     * @return
     */
    public static String solution(String s){

        if (s == null || s.length() == 0){
             return s;
         }
         char[] chs = s.toCharArray();
         Set<Character> vowelSet = new HashSet<>();
         vowelSet.add('a');
         vowelSet.add('i');
         vowelSet.add('o');
         vowelSet.add('u');
         vowelSet.add('e');
         vowelSet.add('A');
         vowelSet.add('E');
         vowelSet.add('I');
         vowelSet.add('O');
         vowelSet.add('U');

         int head =0;
         int tail = chs.length-1;

         char temp;
         while (head<= tail){

             while (head<= tail&&!vowelSet.contains(chs[head])){
                 head++;
             }
             while (head<= tail&&!vowelSet.contains(chs[tail])){
                 tail--;
             }

             if (head <= tail){
                 temp = chs[head];
                 chs[head] = chs[tail];
                 chs[tail] = temp;
                 tail--;
                 head++;
             }
         }
         return new String(chs);
    }

    public static void main(String[] args) {

        String s = "hello";
        System.out.println(solution(s));
    }
}
