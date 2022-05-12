package LinkedList;

import Entitys.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author dekai.kong
 * @difficult hard
 * @create 2022-05-11 17:00
 * @from https://leetcode.cn/problems/vvXgSW/
 * 剑指 Offer II 078. 合并排序链表
 * 给定一个链表数组，每个链表都已经按升序排列。
 *
 * 请将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 **/
public class MergeTwoSortedListsII {
    public MergeTwoSortedListsII() {

    }

    /**
     * 执行结果：
     * 通过
     * 执行用时：
     * 8 ms , 在所有 Java 提交中击败了 23.63% 的用户
     * 内存消耗： 43.1 MB , 在所有 Java 提交中击败了 70.61% 的用户
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {return null;}
        List<ListNode> rst = new ArrayList();
        for(int i =0;i< lists.length ;i++){
            ListNode li = lists[i];
            while(li!=null){
                rst.add(li);
                li = li.next;
            }
        }
        rst.sort(Comparator.comparingInt(o -> o.val));

        for (int i = 0; i < rst.size()-1; i++) {
            rst.get(i).next = rst.get(i+1);
        }
        if(rst.size() == 0){
            return null;
        }
        return rst.get(0);
    }

    /**
     * 优先队列方式!
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        for(ListNode node : lists){
            if(node != null){
                queue.offer(node);
            }
        }
        ListNode head = new ListNode();
        ListNode cur = head;
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            cur.next = node;
            cur = node;
            if(node.next != null){
                queue.offer(node.next);
            }
        }
        return head.next;
    }

    @Test
    public void test() {
        ListNode listNode1 = ListNode.GenerateListNode(new int[]{1, 4, 5});
        ListNode listNode2 = ListNode.GenerateListNode(new int[]{1, 3, 4});
        ListNode listNode3 = ListNode.GenerateListNode(new int[]{2, 6});
        ListNode[] listNodes = new ListNode[]{listNode1,listNode2,listNode3};
        listNodes = new ListNode[]{};
        ListNode listNode = mergeKLists(listNodes);
        System.out.println(listNode);
    }
}
