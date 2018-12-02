package LinkedList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
     * O(n)
     * Runtime: 6 ms, faster than 99.10% of Java online submissions for Remove Nth Node From End of List.
     */

    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0);
        ListNode secd = head;
        if(head!=null && head.next!=null){
            secd = head.next;
        }
        node.next = secd;

        ListNode tem;
        while(head!=null){
            if(head.next!=null){
                tem = head.next;
                head.next = tem.next;
                tem.next = head;
            }
            head = head.next;

        }

        return node.next;
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

        swapPairs(l1);
    }
}
