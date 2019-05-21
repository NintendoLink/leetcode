/**
 * @Author: LinK
 * @Date: 2019/5/20 15:35
 */

package com.qhl.leetcode.basestructure;

public class BSTreeTest {

    public static void main(String[] args) {

        BSTree bsTree = new BSTree();

        bsTree.put(10);
        bsTree.put(9);
        bsTree.put(15);
        bsTree.put(100);
        bsTree.put(1);
        bsTree.put(17);

        bsTree.delete(10);
        bsTree.getElement().forEach(integer -> System.out.println(integer));
        System.out.println(bsTree.getRoot().val);
    }
}
