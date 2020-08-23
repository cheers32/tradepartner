package Q050_Q099;

import ds.ListNode;

public class Q083 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        //ListNode pre = dummy;  // this pre is unnecessary
        while(cur != null && cur.next != null) {
            ListNode next = cur.next;
            if(next.val != cur.val) {
                //pre = cur;
                cur = next;
            } else {
               while(next != null && cur.val == next.val) {
                   next = next.next;
               }
               cur.next = next;
               //pre = cur;
               cur = next;
            }
        }
        return dummy.next;
    }
}
