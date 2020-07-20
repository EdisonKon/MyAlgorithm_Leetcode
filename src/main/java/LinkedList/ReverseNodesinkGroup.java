package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Stack;
import java.util.concurrent.*;
import java.util.concurrent.locks.StampedLock;

/**
 *
 * Hard
 * @author dekai.kong
 *
 * @from https://leetcode.com/problems/reverse-nodes-in-k-group/
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:
Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesinkGroup {
    public ReverseNodesinkGroup(){

    }
    /**
     * Runtime: 2 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
     * 先算一下长度,看是不是大于等于k,如果是,那就继续去next,如果不够k 那就直接返回head
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 0 || head == null)
            return head;
        ListNode c = head;
        int temp = k;
        while(temp > 0){
            c = c.next;
            --temp;
            if(c==null && temp !=0)
                return head;
        }
        //先算一下长度
        temp = k;
        ListNode cur = head, prev = null, nex = null;

        while(temp > 0 && cur !=null){
            nex = cur.next;  //下一个等于当前的下一个
            cur.next = prev; //当前的下一个等于前一个
            prev = cur;      //前一个等于当前的
            cur = nex;       //当前值等于前一个值
            --temp;
        }
        head.next = reverseKGroup(nex, k);
        return prev;
    }

    /**
     * 参考 leetcode reverseKGroup3 写的
     * 这个慢在while要每次new 一个listNode
     * Runtime: 4 ms, faster than 87.80% of Java online submissions for Reverse Nodes in k-Group.
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode temp = head;
        ListNode ans = null;
        ListNode end = null;
        int culen = 0;
        while(culen < k && temp!=null){
            ListNode cur = new ListNode(temp.val);
            cur.next = ans;
            ans = cur;
            if(end == null){
                end = cur;
            }
            temp = temp.next;
            culen++;
        }
        if(culen == k){
            end.next = reverseKGroup2(temp,k);
            return ans;
        }else{
            return head;
        }
    }
    /**
     * leetcode
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup3(ListNode head, int k) {
        int num = 0;
        ListNode temp = head;
        ListNode ans = null;
        ListNode end = null;
        while (num < k && temp != null) {
            ListNode node = new ListNode(temp.val);
            node.next = ans;
            ans = node;
            if (end == null) {
                end = ans;
            }
            temp = temp.next;
            num++;
        }
        Stack stack = new Stack();
        stack.pop();

        if (num == k) {
            end.next = reverseKGroup3(temp, k);
            return ans;
        } else {
            return head;
        }

    }
    @Test
    public void test(){
        int[] a = {1,2,3,4,5,6};
//        int[] a = {1};int tar = 1;
        ListNode l1 = new ListNode(a[0]);
        ListNode tem = l1;
        for(int i=1;i<a.length;i++){
            ListNode lx = new ListNode(a[i]);
            tem.next = lx;
            tem = tem.next;
        }

        reverseKGroup2(l1,4);
//        reverseKBack(l1);
    }

    public ListNode reverseKBack(ListNode l,int k){
        ListNode temp = l;
        ListNode ans = null;
        ListNode end = null;
        int count = 0;
        while(temp!=null && count<k){
            ListNode node = new ListNode(temp.val);
            node.next = ans;
            ans = node;
            if(end==null){
                end = ans;
            }
            temp = temp.next;
            count++;
        }
        if(count == k){
            end.next = reverseKBack(temp,k);
            return ans;
        }else{
            return l;
        }
    }

}
