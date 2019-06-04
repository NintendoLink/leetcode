/**
 * @Author: LinK
 * @Date: 2019/6/4 14:53
 */

package com.qhl.leetcode.list;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

 示例 1:

 输入: 1->2->3->3->4->4->5
 输出: 1->2->5
 示例 2:

 输入: 1->1->1->2->3
 输出: 2->3
 */
public class DeleteDuplicatessSolution {

    private static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思路
     * 1、双指针法 pre cur（代码有问题，当一开始就出现重复元素时，返回结果错误）
     * @param head
     * @return
     */
    public static ListNode solution(ListNode head){

        if (head == null){
            return head;
        }

//        ListNode pre = head;
//        ListNode cur = pre.next;
        ListNode pre = new ListNode(0);
        ListNode cur = head;
        pre.next = cur;
        while (cur != null){
            if (cur.next!=null && cur.val == cur.next.val){
                ListNode temp = cur;
                while (cur !=null && cur.val == temp.val){
                    cur = cur.next;
                }
                if (cur == null){
                    pre.next = null;
                    return head;
                }
//                if (cur!= null && cur.val != cur.next.val){
//                    System.out.println(cur.val);
//                    pre.next = cur;
//                    pre = pre.next;
//                    cur = cur.next;
//
            }else {
                pre.next = cur;
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node = solution(node1);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
