package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-17 16:53
 * @from https://leetcode.com/problems/rotate-list/
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */

public class RotateList {
    public RotateList() {

    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode count = head;
        ListNode acc = head;
        int len = 0;
        for (int i = 0; i < k; i++) {
            if(count == null){//判断是否是最后一个
                len = i;
                break;
            }
            count = count.next;//移除个数
        }

        for (int i = 0; i < k%(len==0?1:len); i++) {
            acc=acc.next;
        }
        ListNode temp = acc.next;
        ListNode nh = reverse(acc.next);
        temp.next = acc;
        acc.next = null;
        return nh;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode dofor = head;
        while(dofor!=null){
            ListNode temp = dofor.next;
            dofor.next = prev;
            prev = dofor;
            dofor = temp;
        }
        return prev;
    }

    @Test
    public void test() {
//        int[] a = {1,2,3,4,5};
        int[] a = {1,2,3};int tar = 1;
        ListNode l1 = new ListNode(a[0]);
        ListNode tem = l1;
        for(int i=1;i<a.length;i++){
            ListNode lx = new ListNode(a[i]);
            tem.next = lx;
            tem = tem.next;
        }
        rotateRight(l1,4);
    }
}

