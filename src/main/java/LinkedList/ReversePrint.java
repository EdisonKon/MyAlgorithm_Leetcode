package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author dekai.kong
 * @difficult easy
 * @create 2020-07-27 21:42
 * @from
 **/
public class ReversePrint {
    public ReversePrint() {

    }

    List<Integer> list = new ArrayList();

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        helper(head);
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public void helper(ListNode head) {
        if(head!=null){
            if(head.next!=null){
                helper(head.next);
            }
            list.add(head.val);
        }
    }

    public int[] reversePrint2(ListNode head) {
        Stack<Integer> s = new Stack();
        while(head!=null){
            s.push(head.val);
            head = head.next;
        }
        int[] ans = new int[s.size()];
        int i = 0;
        while(!s.isEmpty()){
            ans[i++] = s.pop();
        }
        return ans;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(-1);
        ListNode lx = l1;
        int[] x = {1,2,3};
        for (int i = 0; i < x.length; i++) {
            lx.next = new ListNode(x[i]);
            lx = lx.next;
        }
        reversePrint(l1.next);
    }
}
