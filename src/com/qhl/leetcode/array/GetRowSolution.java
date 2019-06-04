/**
 * @Author: LinK
 * @Date: 2019/6/3 10:32
 */

package com.qhl.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 119. 杨辉三角 II（*）
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。

 示例:

 输入: 3
 输出: [1,3,3,1]
 进阶：

 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class GetRowSolution {

    /**
     * 思路
     * 1、最笨的方法
     * 2、优化到o(k)的时间复杂度
     * @param rowIndex
     * @return
     */
    public static List<Integer> solution(int rowIndex){

        List<List<Integer>> tempList = new ArrayList<>();
        if (rowIndex < 0){
            return null;
        }
        int[] lineOne = {1};
        int[] lineTwo = {1,1};
        int[] temp;

        if (rowIndex < 1){
            tempList.add(Arrays.stream(lineOne).boxed().collect(Collectors.toList()));
            return tempList.get(tempList.size()-1);

        }else if (rowIndex < 2){
            tempList.add(Arrays.stream(lineOne).boxed().collect(Collectors.toList()));
            tempList.add(Arrays.stream(lineTwo).boxed().collect(Collectors.toList()));
            return tempList.get(tempList.size()-1);
        }
        temp = lineTwo;
        for (int i = 2;i<rowIndex+1;i++){
            int[] line = new int[i+1];
            for (int j = 0;j<=i;j++){
                if (j == 0 || j == i){
                    line[j] = 1;
                }else {
                    line[j] = temp[j-1] + temp[j];
                }
            }
            tempList.add(Arrays.stream(line).boxed().collect(Collectors.toList()));
            temp = line;
        }

        return tempList.get(tempList.size()-1);
    }

    public static void main(String[] args) {

        solution(3).stream().forEach(integer -> System.out.println(integer));
    }
}
