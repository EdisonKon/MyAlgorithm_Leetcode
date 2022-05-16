package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult easy
 * @create 2022-05-16 10:18
 * @from https://leetcode.cn/problems/palindrome-linked-list-lcci/
 * 面试题 02.06. 回文链表
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 *
 *
 * 示例 1：
 *
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 *
 * 输入： 1->2->2->1
 * 输出： true
 *
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 **/
public class IsPalindromeJZOF {
    public IsPalindromeJZOF() {

    }

    /** 执行用时： 2 ms , 在所有 Java 提交中击败了 54.51% 的用户 内存消耗： 45.3 MB ,
     * 在所有 Java 提交中击败了 11.77% 的用户 @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode reverseHead = null;
        ListNode oldHead = head;
        while (head != null) {
            ListNode temp = head.next;
            ListNode tHead = new ListNode(head.val);
            tHead.next = reverseHead;
            reverseHead = tHead;
            head = temp;
        }
        while (oldHead!=null && reverseHead!=null) {
            if(oldHead.val != reverseHead.val) {return false;}
            oldHead = oldHead.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

    @Test
    public void test() {
        isPalindrome(ListNode.GenerateListNode(new int[]{1}));
    }
}
