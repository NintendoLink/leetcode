/**
 * @Author: LinK
 * @Date: 2019/6/20 11:14
 */

package com.qhl.leetcode.tree;

/**
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

 示例 1:

 输入:
 Tree 1                     Tree 2
 1                         2
 / \                       / \
 3   2                     1   3
 /                           \   \
 5                             4   7
 输出:
 合并后的树:
 3
 / \
 4   5
 / \   \
 5   4   7
 */
public class MergeTreesSolution {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归算法
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode mergeTree(TreeNode t1,TreeNode t2){
        solution(t1,t2);
        return t1;
    }

    public static TreeNode solution(TreeNode t1,TreeNode t2){

        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }

        t1.val += t2.val;

        t1.left = solution(t1.left,t2.left);
        t1.right = solution(t1.right,t2.right);

        return t1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(9);
        TreeNode rootRight = new TreeNode(20);

        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);

        solution(root,root);
    }
}
