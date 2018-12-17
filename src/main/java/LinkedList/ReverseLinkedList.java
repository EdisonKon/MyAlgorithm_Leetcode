package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

/**
 * @description: 描述 Easy
 * @author: dekai.kong
 * @date: 2018-12-17 17:34
 * @from https://leetcode.com/problems/reverse-linked-list/
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * TODO 多刷,链表翻转
 */

public class ReverseLinkedList {
    public ReverseLinkedList() {

    }

    public ListNode reverseList(ListNode head) {
        ListNode l1 = null;
        ListNode l2 = head;
        while(l2!=null){
            ListNode temp = l2.next;
            l2.next = l1;
            l1 = l2;
            l2 = temp;
        }
        return l1;
    }

    /**
     * 递归recursive
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    @Test
    public void test() {
        int[] a = {1,2,3};int tar = 1;
        ListNode l1 = new ListNode(a[0]);
        ListNode tem = l1;
        for(int i=1;i<a.length;i++){
            ListNode lx = new ListNode(a[i]);
            tem.next = lx;
            tem = tem.next;
        }
        reverseList(l1);
    }
}

