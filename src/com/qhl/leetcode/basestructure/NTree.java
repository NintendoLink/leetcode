/**
 * @Author: LinK
 * @Date: 2019/5/24 15:27
 */

package com.qhl.leetcode.basestructure;

import java.util.List;

/**
 * N叉树的定义
 */
public class NTree {

    public int val;
    public List<NTree> children;

    public NTree() {
    }

    public NTree(int val, List<NTree> children) {
        this.val = val;
        this.children = children;
    }
}

