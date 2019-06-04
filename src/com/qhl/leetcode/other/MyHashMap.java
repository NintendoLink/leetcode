/**
 * @Author: LinK
 * @Date: 2019/6/3 16:08
 */

package com.qhl.leetcode.other;

/**
 * 706. 设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射

 具体地说，你的设计应该包含以下的功能

 put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 remove(key)：如果映射中存在这个键，删除这个数值对。

 示例：

 MyHashMap hashMap = new MyHashMap();
 hashMap.put(1, 1);
 hashMap.put(2, 2);
 hashMap.get(1);            // 返回 1
 hashMap.get(3);            // 返回 -1 (未找到)
 hashMap.put(2, 1);         // 更新已有的值
 hashMap.get(2);            // 返回 1
 hashMap.remove(2);         // 删除键为2的数据
 hashMap.get(2);            // 返回 -1 (未找到)

 注意：

 所有的值都在 [1, 1000000]的范围内。
 操作的总数目在[1, 10000]范围内。
 不要使用内建的哈希库。
 */
public class MyHashMap {

    /**
     * 思路
     * 模仿Java的HashMap
     * 1、动态可伸的 哈希桶数组（空间上的优化）
     * 2、数组的容量设计成 2的n次方（取模运算变成取取整运算--->>>速度上的优化）
     * 3、使用数组+链表的方式解决冲突问题
     */
    class node{
        int key;
        int value;
        node next;
        public node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    // container
    private node[] table;

    // size
    private int size;

    // init table length
    public static final int INIT_TABLE_LENGTH = 2;

    // max table length
    public static final int MAX_TALBE_LENGTH = 1000000;


    public MyHashMap() {
        this.table = new node[INIT_TABLE_LENGTH];
        this.size = 0;

    }

    public void put(int key, int value){

        if (size == table.length){
            resize(table);
        }

        int hash = myHash(key,table.length);

        if (table[hash] !=null){
            node node = table[hash];

            //first node
            if (node.key == key){
                node.value = value;
                return;
            }

            while (node.next!=null){

                if (node.next.key == key){
                    node.next.value = value;
                }
                node = node.next;

            }
            node.next = new node(key,value);
            size++;
        }else {
            table[hash] = new node(key,value);
            size++;
        }
    }

    private void resizePut(node putNode,node[] newTable){

        int hash = myHash(putNode.key,newTable.length);

        if (newTable[hash] != null){

            node temp = newTable[hash];

            while (temp.next != null){
                temp = temp.next;
            }

            temp.next = new node(putNode.key,putNode.value);
        }else {
            newTable[hash] = new node(putNode.key,putNode.value);
        }

    }

    private void resize(node[] table) {

        node[] newTable = new node[this.table.length * 2];

        for (int i =0;i<table.length;i++){

            if (table[i] != null){

                node putNode = table[i];

                while (putNode!=null){
                    resizePut(putNode,newTable);
                    putNode = putNode.next;
                }
            }
        }
        this.table = newTable;
    }

    public int get(int key){

        int hash = myHash(key,table.length);

        return table[hash] == null? -1 : searchKey(table[hash],key);
    }

    private int searchKey(node node, int key) {

        while (node!=null){

            if (node.key == key){
                return node.value;
            }
            node = node.next;

        }
        return -1;
    }

    public void remove(int key){

        int hash = myHash(key,table.length);

        if (table[hash] !=null){
            node node = table[hash];
            //remove first node
            if (node.key == key){
                table[hash] = node.next;
                size--;
                return;
            }
            while (node.next != null){

                if (node.next.key == key){
                    node.next = node.next.next;
                    size--;
                    return;
                }
                node = node.next;
            }
        }
    }

    private int myHash(int key,int length) {

        return key & (length-1);
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();

//        hashMap.remove(14);
//        hashMap.get(4);
//        hashMap.put(7,3);
//        hashMap.put(11,1);
//        hashMap.put(12,1);
//        System.out.println(hashMap.get(7));

//        hashMap.put(1,1);
//        hashMap.put(2,2);
//        System.out.println(hashMap.get(2));
//        hashMap.put(2,1);
//        System.out.println(hashMap.get(2));

        for (int i = 0;i<10000;i++){
            int random = (int) (Math.random() * 5000);

            if (random < 2000){
                System.out.println(random);
                hashMap.put(random,random);
            }else if (random <4000){
                System.out.println(random);
//                System.out.println(hashMap.get(random));
            }else {
                System.out.println(random);
                hashMap.remove(random);
            }
        }

//        for (int i =0;i<10;i++){
//            hashMap.put(i,i);
//        }
//
//        for (int i =0;i<10;i++){
//            hashMap.remove(i);
//        }

//        hashMap.put(1,19);
//        hashMap.put(0,3);
//        hashMap.put(1,8);
//        hashMap.put(2,6);

//        [null,null,-1,null,null,null,-1,null,null,null,null]
//        [null,null,-1,null,null,null,3,null,null,null,null]
    }
}
