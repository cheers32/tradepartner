package Q200_Q249;

import ds.ListNode;

public class Q203 {
    public ListNode removeElements(ListNode head, int val) { // N, good simple solution
        ListNode res = new ListNode(-1);  // a dummy head is needed
        res.next = head;
        ListNode prev = res;
        ListNode n = head;
        while(n != null) {
            if(n.val == val) {
                prev.next = n.next;  // only updating prev.next if matching
            } else {
                prev = prev.next;  // only advance prev is not matching
            }
            n = n.next;  // always advance n
        }
        return res.next;
    }
}
