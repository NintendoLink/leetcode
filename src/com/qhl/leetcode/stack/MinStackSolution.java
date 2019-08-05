/**
 * @Author: LinK
 * @Date: 2019/8/5 13:38
 */

package com.qhl.leetcode.stack;

import java.util.Arrays;

/**
 * 155. 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

 push(x) -- 将元素 x 推入栈中。
 pop() -- 删除栈顶的元素。
 top() -- 获取栈顶元素。
 getMin() -- 检索栈中的最小元素。
 示例:

 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> 返回 -3.
 minStack.pop();
 minStack.top();      --> 返回 0.
 minStack.getMin();   --> 返回 -2.

 */
public class MinStackSolution {

    private int[] table;
    private int topIndex;

    private final static int INIT_SIZE = 2;

    /**
     * 思路
     * 1、普通排序算法
     * 2、每次入栈2个元素，一个是入栈的元素本身，一个是当前栈元素的最小值 * 如：入栈序列为2-3-1，则入栈后栈中元素序列为：2-2-3-2-1-1 * 用空间代价来换取时间代价
     */
    public MinStackSolution() {
        this.table = new int[INIT_SIZE];
        topIndex = -1;
    }

    public void push(int x) {


        //normal push
        if (table!= null && table.length-1 > topIndex){

            this.table[++topIndex]  = x;
            return;
        }

        if (resize()){
            push(x);
        }
    }

    private boolean resize() {

        //resize
        // newTable.length = table.length * 2
        int[] newTable = new int[this.table.length *2];

        for (int i = 0;i<this.table.length;i++){
            newTable[i] = this.table[i];
        }
        this.table = newTable;
        return true;
    }
    public void pop() {

        if (this.table !=null && this.topIndex >= 0){
            topIndex--;
            return;
        }

    }

    public int top() {

        if (this.table !=null && this.topIndex >= 0){
            return this.table[topIndex];
        }
        return 0;
    }

    public int getMin() {

        int[] tempInt = Arrays.copyOfRange(this.table,0,topIndex +1);
        Arrays.sort(tempInt);
        if (tempInt.length >0){
            return tempInt[0];
        }
        return 0;
    }

    public static void main(String[] args) {
        MinStackSolution minStack = new MinStackSolution();

//        minStack.push(1);
//        minStack.push(2);
//        minStack.push(3);
//        minStack.push(4);
//
//
//        minStack.pop();
//        minStack.pop();
//        minStack.pop();
//
//        System.out.println(minStack.top());

        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);

        minStack.top();
        minStack.pop();
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();

        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }
}
