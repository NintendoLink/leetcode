/**
 * @Author: LinK
 * @Date: 2019/6/20 9:39
 */

package com.qhl.leetcode.something;

public interface LambdaDemo {
    int sum(int x, int y);

    public static void main(String[] args) {
        LambdaDemo demo = (x,y) ->x + y;
        System.out.println(demo.sum(5,6));
    }
}
