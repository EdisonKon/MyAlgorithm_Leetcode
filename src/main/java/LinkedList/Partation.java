package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult Medium
 * @create 2020-07-27 20:40
 * @from 面试题 02.04. 分割链表
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 *
 * 示例:
 *
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Partation {
    public Partation() {

    }

    public ListNode partition(ListNode head, int x) {
        ListNode p1 = new ListNode(-1);
        ListNode p2 = new ListNode(-1);
        ListNode h1 = p1;
        ListNode h2 = p2;

        while (head != null) {
            if (head.val < x) {
                h1.next = head;
                h1 = h1.next;
            } else {
                h2.next = head;
                h2 = h2.next;
            }
            head = head.next;
        }
        h1.next = p2.next;
        h2.next = null;
        return p1.next;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(-1);
        ListNode lx = l1;
        int[] x = {3,5,8,5,10,2,1};
        for (int i = 0; i < x.length; i++) {
            lx.next = new ListNode(x[i]);
            lx = lx.next;
        }
        partition(l1.next,5);

    }
}