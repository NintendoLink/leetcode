/**
 * @Author: LinK
 * @Date: 2019/5/22 11:24
 */

package com.qhl.leetcode.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 804. 唯一摩尔斯密码词
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。

 为了方便，所有26个英文字母对应摩尔斯密码表如下：

 [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。

 返回我们可以获得所有词不同单词翻译的数量。

 例如:
 输入: words = ["gin", "zen", "gig", "msg"]
 输出: 2
 解释:
 各单词翻译如下:
 "gin" -> "--...-."
 "zen" -> "--...-."
 "gig" -> "--...--."
 "msg" -> "--...--."

 共有 2 种不同翻译, "--...-." 和 "--...--.".
 */
public class UuniqueMorseRepresentationsSolution {

    /**
     * 简单的hash算法即可
     * @param words
     * @return
     */
    public static int solution(String[] words){

        String[] moris = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Map<Character,String> ch2Moris = new HashMap<>();
        Set<String> resSet = new HashSet<>();

        for (int i =0;i<moris.length;i++){
            ch2Moris.put((char)(97+i),moris[i]);
        }

        for (String word :words){
            StringBuffer sb = new StringBuffer("");
            for (Character ch: word.toCharArray()){
                sb.append(ch2Moris.get(ch));
            }

            resSet.add(sb.toString());
            sb = null;
        }

        return resSet.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};

        System.out.println(solution(words));
    }
}
