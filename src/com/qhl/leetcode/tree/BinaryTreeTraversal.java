/**
 * @Author: LinK
 * @Date: 2019/5/24 15:35
 */

package com.qhl.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {

    static class Node{
        int val;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public static List<Integer> Traversal(Node root){

        List<Integer> resList = new ArrayList<>();

//        preOderTraversal(resList,root);
//        preOderTraversalNoDigui(resList,root);
        postOderTraversalNoDigui(resList,root);
        return resList;
    }

    /**
     * 后序遍历的另外一种非迭代算法（非正统）
     * 参考 leetcode No590,多叉树的非迭代后续遍历算法
     * @param resList
     * @param root
     */
    private static void postOderTraversalNoDigui(List<Integer> resList, Node root) {

        Stack<Node> resStack = new Stack<>();
        resStack.push(root);

        while (!resStack.isEmpty()){
            Node node = resStack.pop();
            resList.add(node.val);

            if (node.left != null){
                resStack.push(node.left);
            }
            if (node.right != null){
                resStack.push(node.right);
            }
        }

        Collections.reverse(resList);
    }

    /**
     * 前序非递归遍历
     * @param resList
     * @param root
     */
    private static void preOderTraversalNoDigui(List<Integer> resList, Node root) {

        Stack<Node> resStack = new Stack<>();

        /**
         * 1、一直遍历根，然后将左子树赋值为跟，并将根节点加入到栈中
         * 2、栈不为空，说明有的跟还有右子树还未遍历
         */
        while (root != null || !resStack.isEmpty()){

            while (root!= null){
                resList.add(root.val);
                resStack.push(root);
                root = root.left;
            }
            if (!resStack.isEmpty()){
                root = resStack.pop();
                root = root.right;
            }
        }

    }

    /**
     * 前序递归遍历
     * @param resList
     * @param root
     */
    private static void preOderTraversal(List<Integer> resList, Node root) {

        if (root == null){
            return;
        }

        resList.add(root.val);
        preOderTraversal(resList,root.left);
        preOderTraversal(resList,root.right);
    }


    public static void main(String[] args) {

        Node root = new Node(3);
        Node rootLeft = new Node(9);
        Node rootRight = new Node(20);

        Node rightLeft = new Node(15);
        Node rightRight = new Node(7);

        root.left = rootLeft;
        root.right = rootRight;
        rootRight.left = rightLeft;
        rootRight.right = rightRight;
        List<Integer> resList = Traversal(root);

        resList.forEach(integer -> System.out.println(integer));

    }

}
