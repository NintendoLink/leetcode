/**
 * @Author: LinK
 * @Date: 2019/7/15 16:22
 */

package com.qhl.leetcode.string;

/**
 *
 520. 检测大写字母
 给定一个单词，你需要判断单词的大写使用是否正确。

 我们定义，在以下情况时，单词的大写用法是正确的：

 全部字母都是大写，比如"USA"。
 单词中所有字母都不是大写，比如"leetcode"。
 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 否则，我们定义这个单词没有正确使用大写字母。

 示例 1:

 输入: "USA"
 输出: True
 示例 2:

 输入: "FlaG"
 输出: False
 */
public class DetectCapitalUseSolution {

    /**
     * 思路
     * 1、普通的判断方法，写三个判断函数（因为题目就要求三个条件）
     * 2、比较巧妙地方法
     * @param word
     * @return
     */
    public static boolean detectCapitalUse(String word) {

//        if (word != null && !(word.empty())) {
//            char[] chs = word.toCharArray();
//            return isLowCase(chs) || isAllHighCase(chs) || isStandardCase(chs);
//        } else {
//            return false;
//        }

        if (word!= null && !(word.isEmpty())){
            char[] chs = word.toCharArray();
            boolean upper = true;
            boolean lower = true;

            for (int i = 0;i<chs.length;i++){
                if (chs[i] >=  'a') upper = false;
                if (i != 0 && chs[i] <= 'Z') lower = false;
            }
            return upper || lower;
        }

        return false;
    }

    private static boolean isStandardCase(char[] chs) {

        if (chs[0] < 65 || chs[0] > 90){
            return false;
        }

        for (int i =1;i< chs.length;i++){
            if (chs[i] <97 || chs[i] > 122 ){
                return false;
            }
        }
        return true;
    }

    private static boolean isAllHighCase(char[] chs) {

        for (char ch : chs){
            if (ch < 65 || ch > 90){
                return false;
            }
        }

        return true;
    }

    private static boolean isLowCase(char[] chs){

        for (char ch : chs){
            if (ch < 97 || ch > 122){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("Alaka"));
    }
}
