package LinkedList;

import Entitys.ListNode;
import org.junit.Test;
import java.util.Comparator;
import java.util.*;

/**
 *
 * Easy
 * @author dekai.kong
 *
 * @from https://leetcode.com/problems/merge-two-sorted-lists/
    Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

    Example:

    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    public MergeTwoSortedLists(){

    }
    /**
     * O(n)
     * Runtime: 9 ms, faster than 69.98% of Java online submissions for Merge Two Sorted Lists.
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode ret = head;
        List<ListNode> list = new ArrayList<>();
//        while(l1!=null && l2!=null){
//            list.add(l1);
//            list.add(l2);
//            l1 = l1.next;
//            l2 = l2.next;
//        }
        while(l1!=null){
            list.add(l1);
            l1 = l1.next;
        }
        while(l2!=null){
            list.add(l2);
            l2 = l2.next;
        }
        Collections.sort(list,new MyCompax());
        for (int i = 0; i < list.size(); i++) {
            head.next = list.get(i);
            head = head.next;
        }
        return ret.next;
    }
    class MyCompax implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    /**
     * 直接merge法
     * Runtime: 1 ms, faster than 84.74% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 37 MB, less than 97.95% of Java online submissions for Merge Two Sorted Lists.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode lr = null;
        ListNode lrn = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (lr == null) {
                    lr = l1;
                    lrn = lr;
                }else{
                    lr.next = l1;
                    lr = lr.next;
                }
                l1 = l1.next;
                if (lr.val == l2.val) {
                    lr.next = l2;
                    l2 = l2.next;
                    lr = lr.next;
                }
            }else{
                if (lr == null) {
                    lr = l2;
                    lrn = lr;
                }else{
                    lr.next = l2;
                    lr = lr.next;
                }
                l2 = l2.next;
            }
        }
        if(l1==null && l2!=null){
            if(lr!=null){
                lr.next = l2;
            }else{
                lrn = l2;
            }
        }
        if(l2==null && l1!=null){
            if(lr!=null){
                lr.next = l1;
            }else{
                lrn = l1;
            }
        }
        return lrn;
    }

    @Test
    public void test(){
        int[] a = {1,2,4};
        ListNode l1 = new ListNode(a[0]);
        ListNode tem = l1;
        for(int i=1;i<a.length;i++){
            ListNode lx = new ListNode(a[i]);
            tem.next = lx;
            tem = tem.next;
        }
        int[] a1 = {1,2,5};
        ListNode l2 = new ListNode(a1[0]);
        tem = l2;
        for(int i=1;i<a1.length;i++){
            ListNode lx = new ListNode(a1[i]);
            tem.next = lx;
            tem = tem.next;
        }

//        mergeTwoLists(l1,l2);
        mergeTwoLists2(l1,l2);
    }
}
