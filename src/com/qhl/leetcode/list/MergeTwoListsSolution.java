package com.qhl.leetcode.list;

import com.qhl.leetcode.basestructure.ListNode;

/**
 * no:21
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoListsSolution {

    /**
     *思路：类似归并排序的过程
     * 1、不生成新的节点
     * 2、生成新的节点
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode solution(ListNode l1,ListNode l2){

        if (l1 == null || l2 ==null){
            return l1 == null? l2:l1;
        }

        ListNode dummyHead = new ListNode(0);

        ListNode res = dummyHead;
//  思路1 原始解法
        while (l1 != null && l2 !=null){
            if (l1.val < l2.val){
                res.next = l1;
                l1 = l1.next;
            }else {
                res.next = l2;
                l2 = l2.next;
            }

            res = res.next;
        }
        res.next = l1 == null?l2:l1;

//     思路2   新生成节点，不改变原来l1与l2指向的解法
//        while(l1!=null && l2!=null){
//            if (l1.val > l2.val){
//                res.next = new ListNode(l2.val);
//                l2 = l2.next;
//            }else {
//                res.next = new ListNode(l1.val);
//                l1 = l1.next;
//            }
//
//            res = res.next;
//        }
//
//        if (l1 == null){
//            while (l2!=null){
//                res.next = new ListNode(l2.val);
//                res = res.next;
//                l2 = l2.next;
//            }
//        }
//
//        if (l2 == null){
//            while (l1 != null){
//                res.next = new ListNode(l1.val);
//                res = res.next;
//                l1 = l1.next;
//            }
//        }

        while (dummyHead!=null){

            System.out.println(dummyHead.val);
            dummyHead = dummyHead.next;

        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(5);

        ListNode res = solution(l1,l2);


    }
}
