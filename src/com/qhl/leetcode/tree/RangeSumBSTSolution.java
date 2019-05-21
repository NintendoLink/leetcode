/**
 * @Author: LinK
 * @Date: 2019/5/20 14:48
 */

package com.qhl.leetcode.tree;

import com.qhl.leetcode.basestructure.TreeNode;

/**
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。

 二叉搜索树保证具有唯一的值。



 示例 1：

 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 输出：32
 示例 2：

 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 输出：23


 提示：

 树中的结点数量最多为 10000 个。
 最终的答案保证小于 2^31。
 在真实的面试中遇到过这道题？
 */
public class RangeSumBSTSolution {

    public static int res = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        solution(root,L,R);
        return res;
    }

    public static void solution(TreeNode root,int L,int R){

//        递归版本，结果有错误
        //todo

//        if (root == null){
//            return;
//        }
//
//        if (root.val >= L && root.val<= R){
//            res += root.val;
//            solution(root.left,L,R);
//            solution(root.right,L,R);
//        }else if (root.val>R){
//            solution(root.left,L,R);
//        }else {
//            solution(root.right,L,R);
//        }
//    }

        //TODO
        //前序遍历版本，有错误
        if (root == null){
            return;
        }
        if (root.val >= L && root.val<=R){
            res += root.val;
        }
        solution(root.left,L,R);
        solution(root.right,L,R);
    }

    /**
     * 二叉树的前序遍历
     * @param root
     */
    public static void preOrder(TreeNode root){
        if (root == null){
            return;
        }

        System.out.println(root.val);

        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(9);
        TreeNode rootRight = new TreeNode(20);

        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);

        root.left = rootLeft;
        root.right = rootRight;
        rootRight.left = rightLeft;
        rootRight.right = rightRight;

        preOrder(root);
    }
}
