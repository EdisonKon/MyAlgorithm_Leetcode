package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

/**
 * @description: 描述 Easy
 * @author: dekai.kong
 * @date: 2018-12-17 14:47
 * @from https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */

public class RemoveDuplicatesfromSortedList {
    public RemoveDuplicatesfromSortedList() {

    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        int val = head.val;
        ListNode ln = new ListNode(0);
        ln.next = head;
        while(head!=null){
            while(head.next!=null && head.next.val==val){
                head.next = head.next.next;
            }
            head = head.next;
            val = head==null?0:head.val;
        }
        return ln.next;
    }

    @Test
    public void test() {
        int[] a = {1,1,2,3,3};
//        int[] a = {1};int tar = 1;
        ListNode l1 = new ListNode(a[0]);
        ListNode tem = l1;
        for(int i=1;i<a.length;i++){
            ListNode lx = new ListNode(a[i]);
            tem.next = lx;
            tem = tem.next;
        }
        deleteDuplicates(l1);
    }
}

