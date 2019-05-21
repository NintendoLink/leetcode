/**
 * @Author: LinK
 * @Date: 2019/5/20 16:20
 */

package com.qhl.leetcode.basestructure;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.jb51.net/article/143379.htm
 */
public class BSTree {

    static class Node{
        Node parent;
        Node leftChild;
        Node rightChild;
        int val;

        public Node(Node parent, Node leftChild, Node rightChild, int val) {
            super();

            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.val = val;
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(Node parent, int val) {
            this.parent = parent;
            this.val = val;
        }
    }

    private Node root;
    private int size;
    private List<Integer> element;

    public BSTree() {
        super();
    }

    public boolean put(int val){
        return putVal(root,val);
    }

    private boolean putVal(Node node, int val) {

        if (node == null){
            node = new Node(val);
            root = node;
            size++;
            return true;
        }

        Node temp = node;
        Node p;
        int t;

        do {
            p = temp;
            t = temp.val - val;
            if (t>0){
                temp = temp.leftChild;
            }else if (t<0){
                temp = temp.rightChild;
            }else {
                return false;
            }
        }while (temp!=null);

//        Node newNode = new Node(val);
//        newNode.parent = p;

        Node newNode = new Node(p,val);
        if (t>0){
            p.leftChild = newNode;
        }else if (t<0){
            p.rightChild = newNode;
        }else {
            return false;
        }
        size++;
        return true;
    }

    public Node getNode(int val){
        Node temp =root;
        int t;
        do {
            t = temp.val - val;
            if (t>0){
                temp = temp.leftChild;
            }else if (t<0){
                temp = temp.rightChild;
            }else {
                return temp;
            }
        }while (temp!=null);
        return null;
    }

    public boolean delete(int val){
        Node node = getNode(val);
        if (node == null){
            return false;
        }

        Node parent = node.parent;
        Node leftChild = node.leftChild;
        Node rightChild = node.rightChild;

        //case1: All of leftChild and rightChild is null
        //tips: The node to be deleted can be ROOT,if....else
        if (leftChild == null && rightChild == null){
            if (parent!=null){
                if (parent.leftChild == node){
                    parent.leftChild =null;
                }else if (parent.rightChild == node){
                    parent.rightChild =null;
                }
            }else {
                root =null;
                size--;
                return true;
            }

            node = null;
            return true;
        }else if (leftChild ==null && rightChild!=null){
            //case 2: leftChile is null and rightChild is not null
            //tips: the node to be deleted can be its parents rightChild OR leftChild
            if (parent !=null && parent.val<val){
                parent.rightChild = rightChild;
                //todo
                //rigthChild.parent = parent???
            }else if (parent!=null && parent.val>val){
                parent.leftChild = rightChild;
            }else {
                root = rightChild;
            }
            node = null;
            size--;
            return true;
        }else if (leftChild !=null && rightChild == null){
            //case 2: leftChile is not null and rightChild is null
            //tips: the node to be deleted can be its parents rightChild OR leftChild
            if (parent!=null && parent.val<val){
                parent.rightChild = leftChild;
            }else if (parent !=null && parent.val>val){
                parent.leftChild = leftChild;
            }else {
                root = leftChild;
            }
            node = null;
            size--;
            return true;
        }else if (leftChild !=null && rightChild!=null){
            //case 4:
            Node successor = getSuccessor(node);
            int temp = successor.val;
            boolean delete =delete(temp);
            if (delete){
                node.val = temp;
            }
            successor = null;
            size--;
            return true;
        }
        return false;
    }

    private Node getSuccessor(Node node){
        if(node.rightChild != null){
            Node rightChild = node.rightChild;
            while(rightChild.leftChild != null){
                rightChild = rightChild.leftChild;
            }
            return rightChild;
        }
        Node parent = node.parent;
        while(parent != null && (node == parent.rightChild)){
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public List<Integer> getElement(){
        element = new ArrayList<>();

        preOrder(root);
        return element;
    }


    public void preOrder(Node node){

        if (node!=null){
            preOrder(node.leftChild);
//            System.out.println(node.val);
            element.add(node.val);
            preOrder(node.rightChild);
        }
    }

    public Node getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }
}
