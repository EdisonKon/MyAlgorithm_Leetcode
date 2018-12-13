package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * Hard
 * @author dekai.kong
 *
 * @from https://leetcode.com/problems/merge-k-sorted-lists/
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
1->4->5,
1->3->4,
2->6
]
Output: 1->1->2->3->4->4->5->6

 */
public class MergeKSortedLists {
    public MergeKSortedLists(){

    }
    /**
     * O(m*n)
     * Runtime: 15 ms, faster than 55.03% of Java online submissions for Merge k Sorted Lists.
     */

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = new ListNode(0);
        ListNode ret = head;
        List<ListNode> list = new ArrayList<>();
        for (ListNode l1:lists) {
            while(l1!=null){
                list.add(l1);
                l1 = l1.next;
            }
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
        int[] a1 = {5};
        ListNode l2 = new ListNode(a1[0]);
        tem = l2;
        for(int i=1;i<a1.length;i++){
            ListNode lx = new ListNode(a1[i]);
            tem.next = lx;
            tem = tem.next;
        }
        ListNode[] ls = {l1,l2};

        mergeKLists(ls);
    }
}
