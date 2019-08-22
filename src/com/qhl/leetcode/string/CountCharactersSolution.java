/**
 * @Author: LinK
 * @Date: 2019/8/22 14:43
 */

package com.qhl.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1160. 拼写单词
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。

 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。

 注意：每次拼写时，chars 中的每个字母都只能用一次。

 返回词汇表 words 中你掌握的所有单词的 长度之和。

  

 示例 1：

 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 输出：6
 解释：
 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 示例 2：

 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 输出：10
 解释：
 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
  

 提示：

 1 <= words.length <= 1000
 1 <= words[i].length, chars.length <= 100
 所有字符串中都仅包含小写英文字母

 */
public class CountCharactersSolution {

    /**
     * 思路
     * 1、HashMap
     * 2、利用数组下标
     * @param words
     * @param chars
     * @return
     */
    public static int solution(String[] words, String chars) {

        int res = 0;
        if (words == null || words.length ==0 ||
                chars == null || chars.length() ==0){
            return res;
        }

//        Map<Character,Integer> charsMap = getCharsMap(chars);
//        int count =0;
//        for(String word : words){
//            Map<Character,Integer> wordToCharCountMap = getCharsMap(word);
//            count =0;
//            for (Character character:wordToCharCountMap.keySet()){
//                if (!charsMap.containsKey(character) || charsMap.get(character) < wordToCharCountMap.get(character)){
//                    break;
//                }
//                count ++;
//            }
//            if (count == wordToCharCountMap.size()) {
//                res += word.length();
//            }
//        }
        int[] charIndexInt = getCharsInt(chars);

        int count;
        for (String word : words){
            int[] wordIndexInt = getCharsInt(word);
            count =0;
            for (;count< wordIndexInt.length;){
                if (wordIndexInt[count] > charIndexInt[count]){
                    break;
                }
                count++;
            }
            if (count == 26){
                res += word.length();
            }
        }
        return res;
    }

    private static int[] getCharsInt(String str){

        int[] resInt = new int[26];
        for (char ch : str.toCharArray()){
            resInt[ch-97] += 1;
        }

        return resInt;
    }
    private static Map<Character,Integer> getCharsMap(String str){
        Map<Character,Integer> resMap = new HashMap<>();

        for (Character character: str.toCharArray()){
            resMap.put(character,resMap.containsKey(character)? resMap.get(character)+1: 1);
        }

        return resMap;
    }

    public static void main(String[] args) {

        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";

//        String[] words = {"hello","world","leetcode"};
//        String chars = "welldonehoneyr";

        solution(words,chars);

    }
}
