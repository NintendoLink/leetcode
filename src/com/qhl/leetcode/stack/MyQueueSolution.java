/**
 * @Author: LinK
 * @Date: 2019/7/15 15:39
 */

package com.qhl.leetcode.stack;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 使用栈实现队列的下列操作：

 push(x) -- 将一个元素放入队列的尾部。
 pop() -- 从队列首部移除元素。
 peek() -- 返回队列首部的元素。
 empty() -- 返回队列是否为空。
 示例:

 MyQueue queue = new MyQueue();

 queue.push(1);
 queue.push(2);
 queue.peek();  // 返回 1
 queue.pop();   // 返回 1
 queue.empty(); // 返回 false
 说明:

 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */
public class MyQueueSolution {

    private Stack<Integer> leftStack;
    private Stack<Integer> rightStack;

    /**
     * 思路
     * 1、最简单的置换方法
     * 2、优化pop方法，两次pop之间不需要置换。加快执行时间
     */
    public MyQueueSolution() {
        leftStack = new Stack<>();
        rightStack = new Stack<>();
    }

//    public void push(int x){
//        leftStack.push(x);
//    }
//
//    public int pop(){
//        int temp = 0;
//        if (!empty()){
//            while (leftStack.size()!= 1){
//                rightStack.push(leftStack.pop());
//            }
//
//            temp = leftStack.pop();
//        }
//
//        while (!rightStack.isEmpty()){
//            leftStack.push(rightStack.pop());
//        }
//
//        return temp;
//    }
//
//    public int peek(){
//
//        int temp = 0;
//        if (!empty()){
//            while (leftStack.size()!=1){
//                rightStack.push(leftStack.pop());
//            }
//            temp = leftStack.pop();
//        }
//
//        leftStack.push(temp);
//        while (!rightStack.isEmpty()){
//            leftStack.push(rightStack.pop());
//        }
//
//        return temp;
//    }
//
//    public boolean empty(){
//        return leftStack.isEmpty();
//    }

    public void push(int n) {
        while (!rightStack.isEmpty()){
            leftStack.push(rightStack.pop());
        }
        leftStack.push(n);
    }

    public int pop(){
        if (!empty()) {
            while (!leftStack.isEmpty()){
                rightStack.push(leftStack.pop());
            }

            return rightStack.pop();
        } else {
            return 1;
        }
    }

    public int peek(){
        if (!empty()) {
            int temp = pop();
            rightStack.push(temp);
            return temp;
        } else {
            return 1;
        }
    }

    public boolean empty(){
        return leftStack.isEmpty() && rightStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueueSolution queue = new MyQueueSolution();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
