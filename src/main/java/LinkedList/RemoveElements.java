package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author dekai.kong
 * @difficult easy
 * @create 2020-07-27 20:59
 * @from 203. 移除链表元素 / 剑指 Offer 18. 删除链表的节点
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * 要求删除动作是O(1)
 **/
public class RemoveElements {
    public RemoveElements() {

    }

    /**
     * 执行用时：
     * 1 ms , 在所有 Java 提交中击败了 99.73% 的用户 内存消耗： 40.9 MB , 在所有 Java 提交中击败了 6.25% 的用户
     * 剑指 Offer 18. 删除链表的节点 双百
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode headx = new ListNode(-1);
        headx.next = head;
        ListNode temp = headx;
        while(temp!=null && temp.next!=null){
            if(temp.next.val == val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return headx.next;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(-1);
        ListNode lx = l1;
        int[] x = {1,1};
        for (int i = 0; i < x.length; i++) {
            lx.next = new ListNode(x[i]);
            lx = lx.next;
        }
        removeElements(l1.next,1);
    }
}
