package Q050_Q099;

import ds.ListNode;

public class Q083v2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            ListNode next = cur.next;
            if(next.val != cur.val) {
                cur = next;
            } else {
                cur.next = next.next;
            }
        }
        return dummy.next;
    }
}
