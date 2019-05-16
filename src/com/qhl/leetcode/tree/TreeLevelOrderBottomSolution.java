/**
 * @Author: LinK
 * @Date: 2019/5/16 14:23
 */

package com.qhl.leetcode.tree;

import com.qhl.leetcode.basestructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *     3
 *   / \
 *   9  20
 *     /  \
 *  15   7
 *
 *给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）例如：给定二叉树 [3,9,20,null,null,15,7],返回其自底向上的层次遍历为：
 *[[15,7],[9,20],[3]]
 */
public class TreeLevelOrderBottomSolution {

    static Stack<List<Integer>> resStack = new Stack<>();
    static List<List<Integer>> res = new ArrayList<>();

    /**
     * 思路
     * 1(个人)、遍历每一层，并将每一层的孩子节点保存起来，然后递归即可
     * 2、也是利用递归，递归的方式不同
     */
//    思路1

    public static List<List<Integer>> solution(TreeNode root){

        if (root == null){
            return  res;
        }

        List<TreeNode> rootList = new ArrayList<>();
        rootList.add(root);
        levelOrderSolution(rootList);

        while (!resStack.isEmpty()){
            res.add(resStack.pop());
        }

        return res;
    }

    public static void levelOrderSolution(List<TreeNode> treeNodeList){

        if (treeNodeList ==null || treeNodeList.size() == 0){
            return ;
        }
        List<Integer> list = new ArrayList<>();

        List<TreeNode> nodeList = new ArrayList<>();

        for (TreeNode treeNode: treeNodeList){
            list.add(treeNode.val);

            if (treeNode.left!=null){
                nodeList.add(treeNode.left);
            }

            if (treeNode.right!= null){
                nodeList.add(treeNode.right);
            }
        }

        resStack.push(list);

        levelOrderSolution(nodeList);
    }

    //思路2
//    public static void solution(List<List<Integer>> lists,int level,TreeNode root){
//
//        if (root == null){
//            return;
//        }
//
//        if (lists.size() ==  level){
//            List<Integer> list = new ArrayList<>();
//            list.add(root.val);
//            lists.add(list);
//        }else {
//            lists.get(level).add(root.val);
//        }
//
//        solution(lists,level+1,root.left);
//        solution(lists,level+1,root.right);
//
//    }

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

        solution(root);

        for(List list: res){
            List<Integer> integerList= list;
            for (Integer integer: integerList){
                System.out.print(integer + " ");
            }
            System.out.println();
        }


    }
}
