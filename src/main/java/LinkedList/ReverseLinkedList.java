package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

/**
 * @description: 描述 Easy
 * @author: dekai.kong
 * @date: 2018-12-17 17:34
 * @from https://leetcode.com/problems/reverse-linked-list/ 206
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

    public ListNode reverseListx(ListNode head) {
        ListNode newHead = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
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

    /**
     * 递归练习1
     */
    public ListNode reverseRecursive1(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode temp = head.next;
        head.next = null;
        ListNode newHead = reverseRecursive1(temp);
        temp.next = head;
        return newHead;
    }


    /**
     * 练习1
     * @param head
     * @return
     */
    public ListNode reverseListNode(ListNode head){
        ListNode l1 = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = l1;
            l1 = head;
            head = temp;
        }
        return l1;
    }
    /**
     * 练习2
     * @param head
     * @return
     */
    public ListNode reverseListTrain2(ListNode head){
        ListNode rst = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = rst;
            rst = head;
            head = temp;
        }
        return rst;
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
        l1 = reverseList(l1);
        reverseListTrain2(l1);
    }
}

