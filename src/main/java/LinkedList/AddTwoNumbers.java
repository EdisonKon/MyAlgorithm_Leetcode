package LinkedList;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AddTwoNumbers {
    public AddTwoNumbers(){

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rst = new ListNode(0);
        int i = 1;
        Map<Integer,Integer> mapUp = new HashMap<>();
        int zero = l1.val + l2.val;
        rst.val = zero;
        mapUp.put(1,zero > 10?1:0);
        while(l1.next!=null && l2.next!=null){
            ListNode temp = new ListNode(0);
            rst.next = temp;
            temp.val = l1.next.val+l2.next.val+mapUp.get(i);
            i+=1;
            l1 = l1.next;
            l2 = l2.next;
            temp.next = temp;
        }
        while(l1.next!=null){

        }
        while(l2.next!=null){

        }
        return null;
    }

    public int add(int a,int b,int i){
        return a+b+;
    }
    @Test
    public void test(){
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l111 = new ListNode(3);
        l1.next = l11;
        l11.next = l111;
        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(5);
        ListNode l222 = new ListNode(5);
        l2.next = l22;
        l22.next = l222;

        addTwoNumbers(l1,l2);
    }
}
