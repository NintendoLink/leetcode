/**
 * @Author: LinK
 * @Date: 2019/8/8 10:42
 */

package com.qhl.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 225. 用队列实现栈
 * 使用队列实现栈的下列操作：

 push(x) -- 元素 x 入栈
 pop() -- 移除栈顶元素
 top() -- 获取栈顶元素
 empty() -- 返回栈是否为空
 注意:

 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。

 */
public class MyStackSolution {

    private Queue<Integer> leftQueue;
    private Queue<Integer> rightQueue;

    /**
     * 思路
     * 1、用双对列实现
     */
    public MyStackSolution() {
        this.leftQueue = new LinkedList<>();
        this.rightQueue = new LinkedList<>();
    }

    public void push(int x) {

        if (!rightQueue.isEmpty()){
            rightQueue.offer(x);
        }else {
            leftQueue.offer(x);
        }
    }

    public int top(){
        int top = 0;
        if (!empty()){
            if (leftQueue.isEmpty()){
                while (!rightQueue.isEmpty()){
                    top = rightQueue.poll();
                    leftQueue.offer(top);
                }
            }else {
                while ((!leftQueue.isEmpty())){
                    top = leftQueue.poll();
                    rightQueue.offer(top);
                }
            }
        }
        return top;
    }

    public int pop(){
        int pop = 0;
        if (!empty()){
            if (leftQueue.isEmpty()){
                int size = rightQueue.size();
                for (int i = 1;i< size;i++){
                    leftQueue.offer(rightQueue.poll());
                }
                pop = rightQueue.poll();
            }else {
                int size = leftQueue.size();

                for (int i =1;i< size;i++){
                    rightQueue.offer(leftQueue.poll());
                }
                pop = leftQueue.poll();
            }
        }
        return pop;
    }

    public boolean empty(){
        return leftQueue.isEmpty() && rightQueue.isEmpty();
    }

    public static void main(String[] args) {

        MyStackSolution myStack = new MyStackSolution();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        System.out.println(myStack.pop());

        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());

        System.out.println(myStack.pop());
        System.out.println(myStack.top());

        System.out.println(myStack.pop());
        System.out.println(myStack.top());

        System.out.println(myStack.pop());

        System.out.println();

    }
}
