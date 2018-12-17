package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
     * O(n)
     * Runtime: 6 ms, faster than 99.10% of Java online submissions for Remove Nth Node From End of List.
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> listtem = new ArrayList<>();
        ListNode rst = head;
        int len = 0;
        while(rst!=null){
            len++;
            if(listtem.size()==n+1){//取第n个node的前一个当list的0
                listtem.remove(0);//如果等于n个+1个 删除前一个
            }
            listtem.add(rst);//把后一个添加进来
            rst = rst.next;
        }
        if(n == len){
            head = listtem.size()>1?listtem.get(1):null;
        }else{
            listtem.get(0).next = listtem.get(0).next.next;
        }
        return head;
    }

    /**
     * 5 ms leetcode 答案,用2个listnode 一个做计数,另一个取计数剩下的挪动
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode Dummy=new ListNode(0);
        Dummy.next=head;
        ListNode first=Dummy;
        ListNode second=Dummy;
        for (int i=0;i<=n;i++){
            first=first.next;
        }
        while (first!=null)
        {
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return Dummy.next;
    }

    @Test
    public void test(){
        int[] a = {1,2,3,4,5};int tar = 2;
//        int[] a = {1};int tar = 1;
        ListNode l1 = new ListNode(a[0]);
        ListNode tem = l1;
        for(int i=1;i<a.length;i++){
            ListNode lx = new ListNode(a[i]);
            tem.next = lx;
            tem = tem.next;
        }

        removeNthFromEnd2(l1,tar);
    }
}
