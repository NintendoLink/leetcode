/**
 * @Author: LinK
 * @Date: 2019/5/22 10:58
 */

package com.qhl.leetcode.other;

/**
 * 832. 翻转图像
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。

 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。

 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。

 示例 1:

 输入: [[1,1,0],[1,0,1],[0,0,0]]
 输出: [[1,0,0],[0,1,0],[1,1,1]]
 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 示例 2:

 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 说明:

 1 <= A.length = A[0].length <= 20
 0 <= A[i][j] <= 1
 */
public class FlipAndInvertImageSolution {

    /**
     * 常规思路
     * @param A
     * @return
     */
    public static int[][] solution(int[][] A){

        if (A == null || A.length ==0){
            return A;
        }

        for (int i =0;i<A.length;i++){
            for (int j =0;j< (A[i].length+1)/2;j++){
                int temp = A[i][A[i].length-1-j];
                A[i][A[i].length-1-j] = 1-A[i][j];
                A[i][j] = 1-temp;

            }
        }

        return A;
    }

    public static void main(String[] args) {
        int[][] B = {{1,1,0},{1,0,1},{0,0,0}};
//        int[][] B= {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        int[][] A = solution(B);

        for (int i =0;i<A.length;i++){
            for (int j = 0;j<A[i].length;j++){
                System.out.print(A[i][j]);
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
