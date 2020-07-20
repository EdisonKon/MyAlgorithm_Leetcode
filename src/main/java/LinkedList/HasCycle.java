package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult easy
 * @create 2020-07-20 10:07
 * @from 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路 快慢指针
 **/
public class HasCycle {
    public HasCycle() {

    }

    public boolean hasCycle(ListNode head) {
        ListNode fastP = head;
        ListNode slowP = head;
        while (fastP != null && fastP.next != null) {
            fastP = fastP.next.next;
            slowP = slowP.next;
            if (fastP == slowP) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {

    }
}
