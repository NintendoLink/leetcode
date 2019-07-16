/**
 * @Author: LinK
 * @Date: 2019/7/16 15:02
 */

package com.qhl.leetcode.string;

import java.util.HashMap;

/**
 * 748. 最短完整词
 *
 * 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为完整词。在所有完整词中，最短的单词我们称之为最短完整词。

 单词在匹配牌照中的字母时不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。

 我们保证一定存在一个最短完整词。当有多个单词都符合最短完整词的匹配条件时取单词列表中最靠前的一个。

 牌照中可能包含多个相同的字符，比如说：对于牌照 "PP"，单词 "pair" 无法匹配，但是 "supper" 可以匹配。

  

 示例 1：

 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 输出："steps"
 说明：最短完整词应该包括 "s"、"p"、"s" 以及 "t"。对于 "step" 它只包含一个 "s" 所以它不符合条件。同时在匹配过程中我们忽略牌照中的大小写。
  

 示例 2：

 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 输出："pest"
 说明：存在 3 个包含字母 "s" 且有着最短长度的完整词，但我们返回最先出现的完整词。

 */
public class ShortestCompletingWordSolution {

    /**
     * 思路
     * 1、利用HashMap<Character>
     * @param licensePlate
     * @param words
     * @return
     */
    public static String solution(String licensePlate, String[] words){

        HashMap<Character,Integer> licPlateMap = new HashMap<>();

        for (char ch: licensePlate.toCharArray()){

            if ((ch >= 97 && ch <= 122) || (ch <= 90 && ch >=65)){
                char temp = ch >= 97? (char) (ch - 32) : ch;
                licPlateMap.put(temp,licPlateMap.containsKey(temp) ? licPlateMap.get(temp) + 1 : 1);
            }
        }

        int resLen = 999;
        String resStr = "";
        boolean flag;
        for (String word : words){
            flag = true;
            char[] wordChs = word.toCharArray();
            HashMap<Character,Integer> wordCharMap = new HashMap<>();
            for (char ch : wordChs){
                char temp = ch >= 97? (char) (ch - 32) : ch;
                wordCharMap.put(temp,wordCharMap.containsKey(temp) ? wordCharMap.get(temp) + 1 : 1);
            }

            for (Character ch : licPlateMap.keySet()){
                if (!wordCharMap.keySet().contains(ch) || wordCharMap.get(ch) < licPlateMap.get(ch)){
                    flag = false;
                    break;
                }
            }

            if (flag && resLen > wordChs.length){
                resLen = wordChs.length;
                resStr = word;
            }
        }

        return resStr;
    }

    public static void main(String[] args) {
        String licensePlate = "1s3 PSt";
        String[] words = {"step", "steps", "stripe", "stepple"};
//        String licensePlate = "1s3 456";
//        String[] words = {"looks", "pest", "stew", "show"};

        System.out.println(solution(licensePlate,words));

    }
}
