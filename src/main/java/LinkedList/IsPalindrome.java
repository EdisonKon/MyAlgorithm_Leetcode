package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult easy
 * @create 2020-07-27 22:26
 * @from 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class IsPalindrome {
    public IsPalindrome() {

    }

    public boolean isPalindrome(ListNode head) {
        ListNode oh = head;
        ListNode rev = null;
        while (head != null) {
            ListNode temp = head.next;
            ListNode nh = new ListNode(head.val);
            nh.next = rev;
            rev = nh;
            head = temp;
        }
        while (rev != null && oh != null) {
            if (rev.val != oh.val) {
                return false;
            }
            rev = rev.next;
            oh = oh.next;
        }
        return true;
    }

    @Test
    public void test() {
        isPalindrome(ListNode.GenerateListNode(new int[]{1,1,2,1}));
    }
}
