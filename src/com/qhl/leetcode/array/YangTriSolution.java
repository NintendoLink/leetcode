/**
 * @Author: LinK
 * @Date: 2019/5/29 14:21
 */

package com.qhl.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 118. 杨辉三角(*)
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。

 示例:

 输入: 5
 输出:
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class YangTriSolution {

    /**
     * 思路
     * 1、最普通的思路
     * 2、递归法生成通项
     * @param numRows
     * @return
     */
    public static List<List<Integer>> solution(int numRows){

        //思路1
        int[] rowsOne = {1};
        int[] rowsTwo = {1,1};

        List<List<Integer>> resList = new ArrayList<>();

        if (numRows <1){
            return resList;
        }else if (numRows<2){
            resList.add(Arrays.stream(rowsOne).boxed().collect(Collectors.toList()));
            return resList;
        }else if (numRows<3){
            resList.add(Arrays.stream(rowsOne).boxed().collect(Collectors.toList()));
            resList.add(Arrays.stream(rowsTwo).boxed().collect(Collectors.toList()));
            return resList;
        }

        resList.add(Arrays.stream(rowsOne).boxed().collect(Collectors.toList()));
        resList.add(Arrays.stream(rowsTwo).boxed().collect(Collectors.toList()));

        int[] temp = rowsTwo;
        for (int i =2;i<numRows;i++){
            int[] row = new int[i+1];
            for (int j =0;j<=i;j++){

                if (j==0 || j == i){
                    row[j] = 1;
                }else {
                    row[j] = temp[j-1] + temp[j];
                }

            }
            temp = row;
            resList.add(Arrays.stream(row).boxed().collect(Collectors.toList()));
        }

        return resList;
    }

    public static void main(String[] args) {

        List<List<Integer>> resList = solution(5);

        for (List<Integer> list : resList){
            list.stream().forEach(integer -> System.out.print(integer + " "));

            System.out.println();
        }
    }
}
