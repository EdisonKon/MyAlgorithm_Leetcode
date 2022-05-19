package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author dekai.kong
 * @difficult mid
 * @create 2022-05-19 15:03
 * @from https://leetcode.cn/problems/7WHec2/
 *
 * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 *  
 *
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 *
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/7WHec2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class SortListNode {
    public SortListNode() {

    }

    /**
     * 执行用时： 12 ms , 在所有 Java 提交中击败了 22.99% 的用户
     * 内存消耗： 49.6 MB , 在所有 Java 提交中击败了 18.36% 的用户
     */
    public ListNode sortList2(ListNode head) {
        if (head == null) {return head;}
        List<ListNode> rst = new ArrayList();
        ListNode li = head;
        while (li != null) {
            rst.add(li);
            li = li.next;
        }
        rst.sort(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < rst.size() - 1; i++) {
            rst.get(i).next = rst.get(i + 1);
        }
        rst.get(rst.size()-1).next=null;
        return rst.get(0);
    }


    /**
     * 归并排序
     * 这道题考虑时间复杂度优于 O(n^2)O(n
     * 2
     *  ) 的排序算法。题目的进阶问题要求达到 O(n \log n)O(nlogn) 的时间复杂度和 O(1)O(1) 的空间复杂度，时间复杂度是 O(n \log n)O(nlogn) 的排序算法包括归并排序、堆排序和快速排序（快速排序的最差时间复杂度是 O(n^2)O(n
     * 2
     *  )），其中最适合链表的排序算法是归并排序。
     *
     * 归并排序基于分治算法。最容易想到的实现方式是自顶向下的递归实现，考虑到递归调用的栈空间，自顶向下归并排序的空间复杂度是 O(\log n)O(logn)。如果要达到 O(1)O(1) 的空间复杂度，则需要使用自底向上的实现方式。
     *
     * 方法一：自顶向下归并排序
     * 对链表自顶向下归并排序的过程如下。
     *
     * 找到链表的中点，以中点为分界，将链表拆分成两个子链表。寻找链表的中点可以使用快慢指针的做法，快指针每次移动 22 步，慢指针每次移动 11 步，当快指针到达链表末尾时，慢指针指向的链表节点即为链表的中点。
     *
     * 对两个子链表分别排序。
     *
     * 将两个排序后的子链表合并，得到完整的排序后的链表。
     *
     * 上述过程可以通过递归实现。递归的终止条件是链表的节点个数小于或等于 11，即当链表为空或者链表只包含 11 个节点时，不需要对链表进行拆分和排序。
     *
     */
        public ListNode sortList(ListNode head) {
            return sortList(head, null);
        }

        public ListNode sortList(ListNode head, ListNode tail) {
            if (head == null) {
                return head;
            }
            if (head.next == tail) {
                head.next = null;
                return head;
            }
            ListNode slow = head, fast = head;
            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
                if (fast != tail) {
                    fast = fast.next;
                }
            }
            ListNode mid = slow;
            ListNode list1 = sortList(head, mid);
            ListNode list2 = sortList(mid, tail);
            ListNode sorted = merge(list1, list2);
            return sorted;
        }

        public ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummyHead = new ListNode(0);
            ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
            while (temp1 != null && temp2 != null) {
                if (temp1.val <= temp2.val) {
                    temp.next = temp1;
                    temp1 = temp1.next;
                } else {
                    temp.next = temp2;
                    temp2 = temp2.next;
                }
                temp = temp.next;
            }
            if (temp1 != null) {
                temp.next = temp1;
            } else if (temp2 != null) {
                temp.next = temp2;
            }
            return dummyHead.next;
        }

    @Test
    public void test() {
        ListNode listNode = ListNode.GenerateListNode(new int[]{4, 2, 1, 3});
        sortList(listNode);
    }
}
