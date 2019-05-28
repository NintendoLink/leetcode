/**
 * @Author: LinK
 * @Date: 2019/5/28 9:39
 */

package com.qhl.leetcode.array;

/**
 * 867. 转置矩阵
 * 给定一个矩阵 A， 返回 A 的转置矩阵。

 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。



 示例 1：

 输入：[[1,2,3],[4,5,6],[7,8,9]]
 输出：[[1,4,7],[2,5,8],[3,6,9]]
 示例 2：

 输入：[[1,2,3],[4,5,6]]
 输出：[[1,4],[2,5],[3,6]]
 */
public class TransposeSolution {

    /**
     * 思路
     * 常规思路即可
     * @param A
     * @return
     */
    public static int[][] solution(int[][] A){

        if (A == null || A.length ==0){
            return A;
        }

        int hang = A.length;
        int lie = A[0].length;

        int[][] resMatrix = new int[lie][hang];

        for (int i =0;i<hang;i++){
            for (int j = 0;j<lie;j++){
                resMatrix[j][i] = A[i][j];
            }
        }

        return resMatrix;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        int[][] matrix = {{1,2,3}};

        int[][] resMatrix = solution(matrix);

        for (int i=0;i<resMatrix.length;i++){
            for (int j = 0;j<resMatrix[i].length;j++){
                System.out.print(resMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
