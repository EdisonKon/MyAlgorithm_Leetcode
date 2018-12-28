package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

/**
 * @description: 描述 Medium
 * @author: dekai.kong
 * @date: 2018-12-28 10:03
 * @from https://leetcode.com/problems/partition-list/
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */

public class PartitionList {
    public PartitionList() {

    }

    /**
     * Runtime: 1 ms, faster than 26.32% of Java online submissions for Partition List.
     * 与0ms的解法一致 就是执行不到0ms
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return head;
        }
        ListNode rst1 = new ListNode(0);
        ListNode rst2 = new ListNode(0);
        ListNode p1 = null;
        ListNode p2 = null;
        while(head!=null){
            if(head.val<x){
                if(p1==null){
                    p1 = new ListNode(head.val);
                    rst1.next = p1;
                }else{
                    p1.next = new ListNode(head.val);
                    p1 = p1.next;
                }
            }else{
                if(p2==null){
                    p2 = new ListNode(head.val);
                    rst2.next = p2;
                }else{
                    p2.next = new ListNode(head.val);
                    p2 = p2.next;
                }
            }
            head = head.next;
        }
        if(head ==null){
            if(rst1.next != null && rst2.next != null){
                p1.next = rst2.next;
            }else if(rst1.next == null){
                rst1.next = rst2.next;
            }
        }
        return rst1.next;
    }

    @Test
    public void test() {
//        int[] a = {1,2,3,4,5};int tar = 2;
        int[] a = {1,4,3,2,5,2};int tar = 3;
//        int[] a = {4,3,5};int tar = 3;
        ListNode l1 = new ListNode(a[0]);
        ListNode tem = l1;
        for(int i=1;i<a.length;i++){
            ListNode lx = new ListNode(a[i]);
            tem.next = lx;
            tem = tem.next;
        }
        partition(l1,tar);
    }
}

