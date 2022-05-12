package Entitys;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode() {}

    public static ListNode GenerateListNode(int[] x){
        ListNode l1 = new ListNode(-1);
        ListNode lx = l1;
        for (int i = 0; i < x.length; i++) {
            lx.next = new ListNode(x[i]);
            lx = lx.next;
        }
        return l1.next;
    }
}
