/**
 * @Author: LinK
 * @Date: 2019/6/4 11:01
 */

package com.qhl.leetcode.list;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

 示例 1:

 输入: 1->1->2
 输出: 1->2
 示例 2:

 输入: 1->1->2->3->3
 输出: 1->2->3
 * 执行用时 : 2 ms, 在Remove Duplicates from Sorted List的Java提交中击败了78.38% 的用户
 内存消耗 : 36.4 MB, 在Remove Duplicates from Sorted List的Java提交中击败了69.99% 的用户
 */
public class DeleteDuplicatesSolution {

    private static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思路
     * 1、双指针pre cur
     * 2、单指针，效率更高，空间利用更少
     * @param head
     * @return
     */
    public static ListNode solution(ListNode head){
        if (head == null){
            return head;
        }

        ListNode node = head;

        while (node.next!=null){
            if (node.val == node.next.val){
                ListNode temp = node.next;
                while (temp !=null && temp.val == node.val){
                    temp = temp.next;
                }
                node.next = temp;
            }else {
                node = node.next;
            }
        }
//        while (head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }

        return head;
//        ListNode pre = head;
//        ListNode cur = head.next;
//
//        while (cur!=null){
//            if (cur.val == pre.val){
//                pre.next = cur.next;
//            }else {
//                pre = cur;
//            }
//            cur = cur.next;
//        }
//
//        while (head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }
//        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
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
