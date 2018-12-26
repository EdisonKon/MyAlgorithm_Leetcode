package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-26 14:05
 * @from https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 */

public class RemoveDuplicatesfromSortedListII {
    public RemoveDuplicatesfromSortedListII() {

    }

    /**
     * leetcode 0ms
     * @param head
     * @return
     * 遍历所有 如果有就去掉
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode curr = new ListNode(0);
        ListNode result = curr;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
            } else {
                curr.next = new ListNode(head.val);
                curr = curr.next;
            }
            head = head.next;
        }
        return result.next;
    }

    /**
     * Runtime: 1 ms, faster than 71.70% of Java online submissions for Remove Duplicates from Sorted List II.
     * @param head
     * @return
     * 有个标志位去记录上一个遍历到的值
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head!=null){
            ListNode zx = new ListNode(0);
            ListNode nh = new ListNode(0);
            boolean nohas = true;
            zx.next = nh;
            while(head!=null){
                int preval = head.val;
                if(head.next!=null){
                    int curval = head.next.val;
                    if(preval == curval){
                        zx.next.val = preval;
                        nohas = false;
                    }else if(preval != zx.next.val){
                        nh.next = new ListNode(head.val);
                        nh = nh.next;
                        nohas = false;
                    }else if(nohas){
                        nh.next = new ListNode(head.val);
                        nh = nh.next;
                        nohas = false;
                    }
                }else if(preval != zx.next.val){
                    nh.next = new ListNode(head.val);
                    nh = nh.next;
                }
                head = head.next;
            }
            return zx.next.next;
        }
        return head;
    }

    @Test
    public void test() {
        int[] a = {1,2,3,3,4,4,5};
//        int[] a = {0,1,1,1,2,3};
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

