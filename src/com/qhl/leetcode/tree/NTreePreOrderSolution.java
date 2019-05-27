/**
 * @Author: LinK
 * @Date: 2019/5/27 13:56
 */

package com.qhl.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 由此可以引出四个问题
 * 1、二叉树的前序和后序 递归非递归遍历
 * 2、N叉树的前序和后序 递归和非递归遍历
 */
public class NTreePreOrderSolution {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int val,List<Node> children) {
            this.val = val;
            this.children = children;
        }
    };

    public static List<Integer> solution(Node root){

        List<Integer> resList = new ArrayList<>();

//        preOrder(resList,root);
        if (root == null){
            return resList;
        }
        preOrderNonRecursive(resList,root);

        return resList;

    }

    /**
     * N叉树的非递归前序遍历方式
     * @param resList
     * @param root
     */
    private static void preOrderNonRecursive(List<Integer> resList, Node root) {

        Stack<Node> tempStack = new Stack<>();

        tempStack.push(root);
        while(!tempStack.isEmpty()){
            Node node = tempStack.pop();
            resList.add(node.val);
            for (int i = node.children.size()-1;i>-1;i--){
                tempStack.push(node.children.get(i));
            }

        }

    }


    /**
     * 前序遍历递归算法，很简单
     * @param resList
     * @param root
     */
    private static void preOrder(List<Integer> resList, Node root) {

        if (root == null){
            return;
        }
        resList.add(root.val);
        for (Node child : root.children){
            preOrder(resList,child);
        }

    }


}
