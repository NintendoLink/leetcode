/**
 * @Author: LinK
 * @Date: 2019/5/28 14:31
 */

package com.qhl.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 884. 两句话中的不常见单词(*)
 *
 * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）

 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。

 返回所有不常用单词的列表。

 您可以按任何顺序返回列表。



 示例 1：

 输入：A = "this apple is sweet", B = "this apple is sour"
 输出：["sweet","sour"]
 示例 2：

 输入：A = "apple apple", B = "banana"
 输出：["banana"]
 */
public class UncommonFromSentencesSolution {

    /**
     * 思路
     * 1、常规思路，用哈希算法
     * 2、两个字符串拼接，然后hash计数，count为1的即为要找的String
     * @param A
     * @param B
     * @return
     */
    public static String[] solution(String A,String B) {

//        Map<String, Integer> sentAMap = new HashMap<>();
//        Map<String, Integer> sentBMap = new HashMap<>();
//
//
//        List<String> resList = new ArrayList<>();
//        String[] sentASplits = A.split(" ");
//        String[] sentBSplits = B.split(" ");
//
//        for (int i = 0; i < sentASplits.length; i++) {
//            sentAMap.put(sentASplits[i], sentAMap.containsKey(sentASplits[i]) ? sentAMap.get(sentASplits[i]) + 1 : 1);
//        }
//
//        for (int i = 0; i < sentBSplits.length; i++) {
//            sentBMap.put(sentBSplits[i], sentBMap.containsKey(sentBSplits[i]) ? sentBMap.get(sentBSplits[i]) + 1 : 1);
//        }
//
//
//        for (String string : sentAMap.keySet()) {
//            if (sentAMap.get(string) == 1 && !sentBMap.containsKey(string)) {
//                resList.add(string);
//            }
//        }
//        for (String string : sentBMap.keySet()) {
//            if (sentBMap.get(string) == 1 && !sentAMap.containsKey(string)) {
//                resList.add(string);
//            }
//        }
//
//        return resList.toArray(new String[resList.size()]);

//        lambda表达式，将list转换成数组
//        return resList.stream().toArray(n->new String[n]);


        //思路2
        String resString = A + " " + B;
        List<String> resList = new ArrayList<>();
        String[] resSplits = resString.split(" ");
        Map<String,Integer> stringCountMap = new HashMap<>();
        for (int i =0;i<resSplits.length;i++){
            stringCountMap.put(resSplits[i],stringCountMap.containsKey(resSplits[i])? stringCountMap.get(resSplits[i])+1:1);
        }

        for (String str: stringCountMap.keySet()){
            if (stringCountMap.get(str) == 1){
                resList.add(str);
            }
        }

        return resList.stream().toArray(n->new String[n]);

    }

    public static void main(String[] args) {
        String sentenceA = "apple apple";
        String sentenceB = "banana";

        for (String str: solution(sentenceA,sentenceB)){
            System.out.println(str);
        }

    }
}
