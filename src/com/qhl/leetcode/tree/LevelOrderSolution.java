/**
 * @Author: LinK
 * @Date: 2019/5/28 15:18
 */

package com.qhl.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N叉树的层序遍历(*)
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

 例如，给定一个 3叉树
 返回其层序遍历:
 [
 [1],
 [3,2,4],
 [5,6]
 ]
 */
public class LevelOrderSolution {


    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    /**
     * 思路：
     * 二叉树的层序遍历，只不过，这次是增加层序遍历的层次，只需在队列遍历时，全部poll出即可
     * @param root
     * @return
     */
    public static List<List<Integer>>solution(Node root){

        List<List<Integer>> resList = new ArrayList<>();
        if (root == null){
            return resList;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){

            List<Integer> levelResList = new ArrayList<>();
            List<Node> levelNodeList = new ArrayList<>();

            while (!queue.isEmpty()){
                Node tempNode = queue.poll();
                levelResList.add(tempNode.val);
                levelNodeList.add(tempNode);
            }

            resList.add(levelResList);

            for (Node tempNode : levelNodeList){
                for (Node child : tempNode.children){
                    queue.add(child);
                }
            }
        }

        return resList;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
