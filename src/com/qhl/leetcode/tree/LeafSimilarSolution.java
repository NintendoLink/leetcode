/**
 * @Author: LinK
 * @Date: 2019/5/28 10:45
 */

package com.qhl.leetcode.tree;

import com.qhl.leetcode.basestructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 872. 叶子相似的树（简单）
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。

 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。

 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。

 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。


 */
public class LeafSimilarSolution {

    /**
     * 思路
     * 常规算法，先序遍历叶子节点即可
     * @param root1
     * @param root2
     * @return
     */
    public static boolean solution(TreeNode root1,TreeNode root2){
        if (root1 ==null || root2 ==null){
            return false;
        }

        List<Integer> root1List = new ArrayList<>();
        List<Integer> root2List = new ArrayList<>();


        binaryTreeNonRecusiveTravasel(root1List,root1);
        binaryTreeNonRecusiveTravasel(root2List,root2);
        if (root1List.size()!=root2List.size()){
            return false;
        }

        for (int i =0;i<root1List.size();i++){
            if (root1List.get(i) != root2List.get(i)){
                return false;
            }
        }
        return true;
    }

    private static void binaryTreeNonRecusiveTravasel(List<Integer> resList, TreeNode root) {
        Stack<TreeNode> tempStack = new Stack<>();

        while (root!=null || !tempStack.isEmpty()){
            while (root!=null){
                if (root.left ==null && root.right == null) {
                    resList.add(root.val);
                }
                tempStack.push(root);
                root = root.left;
            }
            if (!tempStack.isEmpty()){
                TreeNode node = tempStack.pop();
                root = node.right;
            }
        }
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
        List<Integer> resList = new ArrayList<>();
        binaryTreeNonRecusiveTravasel(resList,root);

        resList.forEach(integer -> System.out.println(integer));

    }


}
