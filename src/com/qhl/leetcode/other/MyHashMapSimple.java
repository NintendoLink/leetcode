/**
 * @Author: LinK
 * @Date: 2019/6/3 15:52
 */

package com.qhl.leetcode.other;

public class MyHashMapSimple {
    private int[] talbe;

    /** Initialize your data structure here. */
    public MyHashMapSimple() {
        talbe = new int[1000000];
        initContainer(talbe);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = myHash(key);
        talbe[hash] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {

        int hash = myHash(key);
        return talbe[hash];
    }

    private int myHash(int key) {

        return key % 1000000;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {

        int hash = myHash(key);
        talbe[hash] = -1;
    }

    private void initContainer(int[] table) {

        for (int i = 0;i<table.length;i++){
            table[i] = -1;
        }
    }
}
