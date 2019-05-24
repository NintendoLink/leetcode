/**
 * @Author: LinK
 * @Date: 2019/5/24 15:29
 */

package com.qhl.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 */
public class NTreePostOrderSolution {

    /**
     * n叉树的定义
     */
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 思路
     * 1、递归算法
     * 2、非递归算法--->>>由此可以引出二叉树的后续遍历非迭代算法
     * @param root
     * @return
     */
    public static List<Integer> solution(Node root){

//        List<Integer> resList = new ArrayList<>();
//
//        nTreePostOrder(resList,root);
//
//        return resList;

        List<Integer> res_pre = new ArrayList<>();
        if(root == null)
            return res_pre;
        Stack<Node> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            Node n = s.pop();
            res_pre.add(n.val);
            for(Node node : n.children)
                s.push(node);
        }
        Collections.reverse(res_pre);
        return res_pre;

    }

    private static void nTreePostOrder(List<Integer> resList, Node root) {

        if (root == null){
            return;
        }
        for (Node children : root.children){
            nTreePostOrder(resList,children);
        }
        resList.add(root.val);
    }
}
