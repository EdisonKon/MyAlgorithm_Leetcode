package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult medium
 * @create 2020-07-20 10:37
 * @from 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class DetectCycle {
    public DetectCycle() {

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fastP = head;
        ListNode slowP = head;
        boolean flag = false;
        while (fastP != null && fastP.next != null) {
            fastP = fastP.next.next;
            slowP = slowP.next;
            if (fastP == slowP) {
                flag = true;
                break;
            }
        }
        if (flag) {
            fastP = head;
            while (fastP != slowP) {
                fastP = fastP.next;
                slowP = slowP.next;
            }
            return fastP;
        } else {
            return null;
        }
    }

    @Test
    public void test() {
        int[] ints = {1,2,3,4,5,6};
        ListNode head = new ListNode(1);
        ListNode l1 = head;
        for (int i = 1; i < ints.length; i++) {
            l1.next = new ListNode(ints[i]);
            l1= l1.next;
        }
        ListNode ln = detectCycle(head);
        System.out.println(ln==null?"null":ln.val);
    }
}
