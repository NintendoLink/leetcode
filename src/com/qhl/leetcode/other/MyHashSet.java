/**
 * @Author: LinK
 * @Date: 2019/6/5 14:16
 */

package com.qhl.leetcode.other;

/**
 * 705. 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合

 具体地说，你的设计应该包含以下的功能

 add(value)：向哈希集合中插入一个值。
 contains(value) ：返回哈希集合中是否存在这个值。
 remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。

 示例:

 MyHashSet hashSet = new MyHashSet();
 hashSet.add(1);
 hashSet.add(2);
 hashSet.contains(1);    // 返回 true
 hashSet.contains(3);    // 返回 false (未找到)
 hashSet.add(2);
 hashSet.contains(2);    // 返回 true
 hashSet.remove(2);
 hashSet.contains(2);    // 返回  false (已经被删除)

 注意：

 所有的值都在 [1, 1000000]的范围内。
 操作的总数目在[1, 10000]范围内。
 不要使用内建的哈希集合库。
 */
public class MyHashSet {

    /**
     * 思路
     * 同HashMap的设计思路
     * tips
     *  1、resizePut要用new Node()，不然会造成指针死循环
     *  2、remove 要在每一个条件满足时返回
     */
    private static class Node{

        int key;
        int hash;
        Node next;

        public Node(int key, int hash) {
            this.key = key;
            this.hash = hash;
        }
    }

    private static final int INIT_CAPICITY = 2;
    private Node[] table;
    private int size;

    /** Initialize your data structure here. */
    public MyHashSet() {
        table = new Node[INIT_CAPICITY];
        size =0;
    }



    public void add(int key) {

        if (size == table.length){
            resize();
        }
        int hash = indexFor(key,table.length);
        Node node = table[hash];

        if (node == null){
            table[hash] = new Node(key,hash);
            size++;
            return;
        }
        if (node.key == key){
            return;
        }
        while (node.next!=null){
            if (node.key == key){
                return;
            }
            node = node.next;
        }
        node.next = new Node(key,hash);
        size++;
    }

    private void resize() {

        Node[] newTable = new Node[table.length * 2];

        for (int i = 0;i<table.length;i++){

            Node node = table[i];

            while (node != null){
                resizePut(node,newTable);
                node = node.next;
            }
        }
        this.table = newTable;

    }

    private void resizePut(Node node, Node[] newTable) {

        int hash = indexFor(node.key,newTable.length);

        Node tempNode = newTable[hash];
        if (tempNode == null){
            newTable[hash] = new Node(node.key,hash);
            return;
        }
        while (tempNode.next!=null){
            tempNode = tempNode.next;
        }
        tempNode.next = new Node(node.key,hash);
    }

    private int indexFor(int key,int tableLength) {

        return key & (tableLength - 1);
    }

    public void remove(int key) {

        int hash = indexFor(key,table.length);
        Node node = table[hash];

        if (node != null){
            if (node.key == key){
                table[hash] = node.next;
                size--;
                return;
            }
            while (node.next!=null){
                if (node.next.key == key){
                    node.next = node.next.next;
                    size--;
                    return;
                }
                node = node.next;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {

        int hash = indexFor(key,table.length);

        Node node = table[hash];

        if (node == null){
            return false;
        }else if (node.key == key){
            return true;
        }

        while (node.next!=null){
            if (node.next.key == key){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public static void main(String[] args) {

        MyHashSet hashSet = new MyHashSet();
//        for (int i = 1;i<100;i++){
//
//            int random = (int) (Math.random() * 6000);
//            if (random <2000){
//                System.out.println("add");
//                hashSet.add(random);
//            }else if (random<4000){
//                System.out.println("contains");
//
//                System.out.println(hashSet.contains(random -3000));
//            }else {
//                System.out.println("remove");
//
//                hashSet.remove(random - 4000);
//            }
//        }



//        hashSet.add(1);
//        hashSet.add(2);
//        hashSet.contains(1);
//        hashSet.contains(3);
//        hashSet.add(2);
//        hashSet.contains(2);
//        hashSet.remove(2);
//        hashSet.contains(2);

//        ["MyHashSet","add","remove","add","remove","remove","add","add","add","add","remove"]
//        [[],[9],[19],[14],[19],[9],[0],[3],[4],[0],[9]]
        hashSet.add(9);
        hashSet.remove(19);
        hashSet.add(14);
        hashSet.remove(19);
        hashSet.remove(9);
        hashSet.add(0);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(0);
//        hashSet.remove(9);
    }
}
