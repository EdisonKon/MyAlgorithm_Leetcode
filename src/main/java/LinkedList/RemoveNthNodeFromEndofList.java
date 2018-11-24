package LinkedList;

import org.junit.Test;

/**
 *
 * Medium
 * @author dekai.kong
 *
 * @from https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */
public class RemoveNthNodeFromEndofList {
    public RemoveNthNodeFromEndofList(){

    }
    /**
     * O(n) 未优化
     * Runtime: 40 ms, faster than 30.65% of Java online submissions for Add Two Numbers.
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {

        return null;
    }
    @Test
    public void test(){
        int[] a = {2,4,4,4};
        int[] b = {5,6,5};
        ListNode l1 = new ListNode(a[0]);
        ListNode l2 = new ListNode(b[0]);
        ListNode tem = l1;
        for(int i=1;i<a.length;i++){
            ListNode lx = new ListNode(a[i]);
            tem.next = lx;
            tem = tem.next;
        }
        tem = l2;
        for(int i=1;i<b.length;i++){
            ListNode lx = new ListNode(b[i]);
            tem.next = lx;
            tem = tem.next;
        }
//        ListNode l1 = new ListNode(2);
//        ListNode l11 = new ListNode(4);
//        ListNode l111 = new ListNode(4);
//        ListNode l1111 = new ListNode(4);
//        l1.next = l11;
//        l11.next = l111;
//        l111.next = l1111;
//        ListNode l2 = new ListNode(5);
//        ListNode l22 = new ListNode(6);
//        ListNode l222 = new ListNode(5);
//        l2.next = l22;
//        l22.next = l222;

        removeNthFromEnd(l1,2);
    }
}
