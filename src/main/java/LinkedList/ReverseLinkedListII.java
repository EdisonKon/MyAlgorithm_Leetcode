package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-18 10:02
 * @from https://leetcode.com/problems/reverse-linked-list-ii/
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */

public class ReverseLinkedListII {
    public ReverseLinkedListII() {

    }

    /**
     * Runtime: 2 ms, faster than 96.61% of Java online submissions for Reverse Linked List II.
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        List<ListNode> list = new ArrayList<>();
        int curlen = 0;
        list.add(new ListNode(0));
        while(head!=null){
            curlen++;
            if(curlen>m && curlen<=n){
                ListNode temp = head.next;
                head.next = list.get(m);
                list.add(m,head);
                head = temp;
                list.get(m-1).next = list.get(m);
                continue;
            }
            if(curlen>n){
                list.get(n).next = head;
                break;
            }
            list.add(head);
            head=head.next;
        }
        list.get(n).next = head;
        return list.get(1);
    }

    /**
     * leetcode 1ms
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = res;
        for(int i=1;i<m;i++) {
            cur = cur.next;
        }

        ListNode preTail = cur;
        ListNode curTail = cur.next;
        cur = cur.next;
        ListNode pre = null;
        for(int i=m;i<=n;i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        preTail.next = pre;
        curTail.next = cur;

        return res.next;
    }

    @Test
    public void test() {
        int[] a = {3,5};
//        int[] a = {1,2,3,4,5};
//        int[] a = {1,2};int tar = 2;
        ListNode l1 = new ListNode(a[0]);
        ListNode tem = l1;
        for(int i=1;i<a.length;i++){
            ListNode lx = new ListNode(a[i]);
            tem.next = lx;
            tem = tem.next;
        }
        reverseBetween(l1,1,2);
    }
}

