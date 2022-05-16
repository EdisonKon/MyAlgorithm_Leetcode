package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

/**
 * @author dekai.kong
 * @difficult mid
 * @create 2022-05-16 13:29
 * @from https://leetcode.cn/problems/merge-in-between-linked-lists/
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 *
 * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
 *
 * 下图中蓝色边和节点展示了操作后的结果：
 *
 *
 * 请你返回结果链表的头指针。
 *
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 * 示例 2：
 * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
 * 解释：上图中蓝色的边和节点为答案链表。
 *
 * 3 <= list1.length <= 104
 * 1 <= a <= b < list1.length - 1
 * 1 <= list2.length <= 104
 **/
public class MergeTwoList {
    public MergeTwoList() {

    }

    /** 执行用时：
     * 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 45.1 MB , 在所有 Java 提交中击败了 5.80% 的用户
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = null;
        ListNode end = null;
        ListNode move = list1;
        int len = 0;
        while(len <= b){
            if(len+1 == a){
                start = move;
            }
            if(len == b){
                end = move.next;
            }
            move = move.next;
            len++;
        }
        move = list2;
        start.next = list2;
        while(move.next != null){
            move = move.next;
        }
        move.next = end;
        return list1;
    }

    @Test
    public void test() {
        ListNode list1 = ListNode.GenerateListNode(new int[]{0,1,2,3,4,5,6});
        ListNode list2 = ListNode.GenerateListNode(new int[]{1000000,1000001,1000002,1000003,1000004});
        ListNode listNode = mergeInBetween(list1, 2, 5, list2);
    }
}
