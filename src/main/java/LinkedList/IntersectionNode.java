package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @author dekai.kong
 * @difficult Easy
 * @create 2020-07-18 19:38
 * @from 160. 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，
 * 相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *----------------------------------------------------------------------------------------------------------------------------
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *
 *
 **/
public class IntersectionNode {
    public IntersectionNode() {

    }

    /**
     * 使用栈的方法 3ms 击败18%..
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        ListNode res = null;
        Stack sa = new Stack();
        Stack sb = new Stack();

        while(tempA!=null){
            sa.push(tempA);
            tempA = tempA.next;
        }
        while(tempB!=null){
            sb.push(tempB);
            tempB = tempB.next;
        }

        while(sa.size()!=0&&sb.size()!=0&&sa.peek() == sb.peek()){
            res = (ListNode)sa.pop();
            sb.pop();
        }
        return res;
    }

    /**
     * 第二种方法,列表a长m 链表b长n 先让长的走m-n个节点,然后开始对比,得到一致的第一个节点就是第一个相交节点
     * 1ms 击败 99.9%的用户
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        ListNode res = null;
        int alen = 0;
        int blen = 0;
        while(tempA!=null){
            alen++;
            tempA = tempA.next;
        }
        while(tempB!=null){
            blen++;
            tempB = tempB.next;
        }
        tempA = headA;
        tempB = headB;
        if(alen > blen){
            for(int i = 0;i<alen - blen;i++){
                tempA = tempA.next;
            }
        }else{
            for(int i = 0;i<blen - alen;i++){
                tempB = tempB.next;
            }
        }

        while(tempA!=null && tempB!=null){
            if(tempA == tempB){
                res = tempA;
                return res;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return res;

    }

    public ListNode getIntersectionNodex(ListNode headA, ListNode headB) {
        int a = 0;
        int b = 0;
        ListNode ha = headA;
        ListNode hb = headB;
        ListNode ans = null;
        while(ha!=null){
            a++;
            ha = ha.next;
        }
        while(hb!=null){
            b++;
            hb = hb.next;
        }
        if(a>b){
            int len = a - b;
            while(len>0){
                headA = headA.next;
                len--;
            }
        }else{
            int len = b - a;
            while(len>0){
                headB = headB.next;
                len--;
            }
        }
        while(headA!=null && headB!=null){
            if(headA == headB){
                ans = headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return ans;
    }



    @Test
    public void test() {
        getIntersectionNodex(ListNode.GenerateListNode(new int[]{4,1,8,4,5}),ListNode.GenerateListNode(new int[]{5,0,1,8,4,5}));
    }
}
