/**
 * @Author: LinK
 * @Date: 2019/6/19 11:01
 */

package com.qhl.leetcode.tree;

import java.util.LinkedList;

/**
 * 700. 二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 例如，
 给定二叉搜索树:

  4
 / \
 2  7
 / \
 1  3

 和值: 2
 你应该返回如下子树:
  2
 / \
 1  3
 */
public class SearchBSTSolution {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思路
     *
     * 1、简单的递归算法，由此可以引出另外一个问题，如果只是一颗普通的二叉树，改如何设计查找？
     * @param root
     * @param val
     * @return
     */
    public static TreeNode solution(TreeNode root,int val){

        if (root == null || root.val == val){
            return root;
        }else if (val < root.val){
            return solution(root.left,val);
        }else {
            return solution(root.right,val);
        }
    }

    /**
     * 使用层序遍历算法
     * @param root
     * @param val
     * @return
     */
    public static TreeNode solutionWithLevelTra(TreeNode root,int val){

        if (root == null){
            return null;
        }

        LinkedList<TreeNode> queue =  new LinkedList<>();

        queue.push(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.pop();
            if (node.val == val){
                return node;
            }
            if (node.left != null){
                queue.push(node.left);
            }
            if (node.right != null){
                queue.push(node.right);
            }
        }

        return null;

    }

    public static void preOrder(TreeNode root){
        if (root ==  null){
            return;
        }

        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
