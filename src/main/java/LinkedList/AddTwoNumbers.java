package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

/**
 *
 * Medium
 * @author dekai.kong
 *
 * https://leetcode.com/problems/add-two-numbers/
 *
 *You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public AddTwoNumbers(){

    }
    /**
     * O(n) 未优化
     * Runtime: 40 ms, faster than 30.65% of Java online submissions for Add Two Numbers.
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rst = new ListNode(0);
        ListNode currentLn = rst;

        boolean isUp = false;
        while(l1!=null && l2!=null){
            currentLn.next = new ListNode(0);
            int currentVal = l1.val + l2.val + (isUp ? 1:0);
            if(currentVal >= 10){
                isUp = true;
                currentLn.val = currentVal-10;
            }else{
                isUp = false;
                currentLn.val = currentVal;
            }
            l1 = l1.next;
            l2 = l2.next;
            if(l1!=null || l2!=null){
                currentLn = currentLn.next;
            }else{
                currentLn.next = null;
                if(isUp){
                    currentLn.next = new ListNode(1);
                }
            }
        }
        if(l1 != null){
            if(isUp){
                while(l1 != null && l1.val == 9){
                    currentLn.val = 0;
                    currentLn.next = new ListNode(0);
                    currentLn = currentLn.next;
                    l1 = l1.next;
                    if(l1 == null){
                        l1 = new ListNode(0);
                    }
                }
                currentLn.val += (l1.val+1);
                currentLn.next = l1.next;
            }else{
                currentLn.val = l1.val;
                currentLn.next = l1.next;
            }
        }
        if(l2 != null){
            if(isUp){
                while(l2.val == 9){
                    currentLn.val = 0;
                    currentLn.next = new ListNode(0);
                    currentLn = currentLn.next;
                    l2 = l2.next;
                    if(l2 == null){
                        l2 = new ListNode(0);
                    }
                }
                currentLn.val += (l2.val+1);
                currentLn.next = l2.next;
            }else{
                currentLn.val = l2.val;
                currentLn.next = l2.next;
            }
        }
        return rst;
    }
    /**直接遍历O(n) 上边方法的优化
     *  Runtime: 23 ms, faster than 94.14% of Java online submissions for Add Two Numbers.
     * * */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode rst = new ListNode(0);
        ListNode currentLn = rst;
        boolean isUp = false;
        while(l1!=null || l2!=null){
            if(currentLn == null){
                currentLn = new ListNode(0);
            }
            int val = (l1!=null?l1.val:0) + (l2!=null?l2.val:0) + currentLn.val;
            if(val >= 10){
                currentLn.val = val -10;
                isUp = true;
            }else{
                currentLn.val = val;
                isUp = false;
            }
            l1 = l1!=null?l1.next:null;
            l2 = l2!=null?l2.next:null;
            if(isUp){
                currentLn.next = new ListNode(1);
            }else{
                currentLn.next = null;
                if(l1!=null || l2!=null){
                    currentLn.next = new ListNode(0);
                }
            }
            currentLn = currentLn.next;
        }
        return rst;
    }
    @Test
    public void test(){
//        int[] a = {2,4,4,4};
//        int[] b = {5,6,5};
//        int[] a = {7,1,6};
//        int[] b = {5,9,2};
        int[] a = {1,8};
        int[] b = {0};
        ListNode l1 = new ListNode(a[0]);
        ListNode l2 = new ListNode(b[0]);
        ListNode tem = l1;
        for(int i=1;i<a.length;i++){
            ListNode lx = new ListNode(a[i]);
            tem.next = lx;
            tem = tem.next;
        }
        tem = l2;
        for(int i=1;i<b.length;i++){
            ListNode lx = new ListNode(b[i]);
            tem.next = lx;
            tem = tem.next;
        }
//        ListNode l1 = new ListNode(2);
//        ListNode l11 = new ListNode(4);
//        ListNode l111 = new ListNode(4);
//        ListNode l1111 = new ListNode(4);
//        l1.next = l11;
//        l11.next = l111;
//        l111.next = l1111;
//        ListNode l2 = new ListNode(5);
//        ListNode l22 = new ListNode(6);
//        ListNode l222 = new ListNode(5);
//        l2.next = l22;
//        l22.next = l222;

//        addTwoNumbersx(l1,l2);
        addTwoNumbersUpgrade(l1,l2);
    }


    /**
     * ------- 2 ms 100.00%   ------   39.8 MB 100.00%
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersx(ListNode l1, ListNode l2) {
        if(l1 == null ){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int up = 0;
        ListNode node = new ListNode(-1);
        ListNode temp = node;
        while(l1!=null && l2!=null){
            int val = l1.val + l2.val + up;
            up = 0;
            if(val>=10){
                up = 1;
                val = val%10;
            }
            temp.next = new ListNode(val);
            l1 = l1.next;
            l2 = l2.next;
            temp = temp.next;
        }
        while(l1!=null){
            int val = l1.val+up;
            up = 0 ;
            if (val >= 10){
                up = 1;
                val = val%10;
            }
            temp.next = new ListNode(val);
            temp = temp.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int val = l2.val+up;
            up = 0 ;
            if (val >= 10){
                up = 1;
                val = val%10;
            }
            temp.next = new ListNode(val);
            temp = temp.next;
            l2 = l2.next;
        }
        if(l1 == null && l2 == null && up == 1){
            temp.next = new ListNode(up);
        }
        return node.next;
    }

    /**
     * 代码结构优化
     */
    public ListNode addTwoNumbersUpgrade(ListNode l1, ListNode l2) {
        int up = 0;
        ListNode node = new ListNode(-1);
        ListNode temp = node;
        while(l1!=null || l2!=null||up == 1){
            int val = (l1==null?0:l1.val) + (l2==null?0:l2.val) + up;
            up = 0;
            if(val>=10){
                up = 1;
                val = val%10;
            }
            temp.next = new ListNode(val);
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return node.next;
    }
}
