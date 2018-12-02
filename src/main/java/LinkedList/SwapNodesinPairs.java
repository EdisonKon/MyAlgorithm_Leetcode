package LinkedList;

import org.junit.Test;

/**
 *
 * Medium
 * @author dekai.kong
 *
 * @from https://leetcode.com/problems/swap-nodes-in-pairs/
Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class SwapNodesinPairs {
    public SwapNodesinPairs(){

    }
    /**
     * self
     * Runtime: 2 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l1 = newHead;
        while(l1.next!=null && l1.next.next!=null){
            ListNode l2 = l1.next.next;
            l1.next.next = l2.next;
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
        }
        return newHead.next;
    }
    /**
     * O(n)
     * Runtime: 2 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
     * from leetcode
     */


    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode l1 = newHead;
        if (head == null || head.next == null) {
            return head;
        }
        do {
            ListNode l2 = l1.next.next;
            l1.next.next = l2.next;
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
        } while (l1.next != null && l1.next.next != null);

        return newHead.next;
    }

    @Test
    public void test(){
        int[] a = {1,2,3,4,5};
//        int[] a = {1};int tar = 1;
        ListNode l1 = new ListNode(a[0]);
        ListNode tem = l1;
        for(int i=1;i<a.length;i++){
            ListNode lx = new ListNode(a[i]);
            tem.next = lx;
            tem = tem.next;
        }

        swapPairs2(l1);
    }
}
