package Q100_Q149;

import ds.ListNode;

public class Q142 {
    public ListNode detectCycle(ListNode head) { // 2*N, simple solution
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
                break;
        }
        if(fast==null || fast.next==null)  // notice this condition to return no-cycle case
            return null;
        fast = head;
        while(fast!=slow) {  // it doesn't matter slow or fast, same result
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
