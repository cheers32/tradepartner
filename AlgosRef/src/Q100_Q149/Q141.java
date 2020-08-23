package Q100_Q149;

import ds.ListNode;

public class Q141 {
    public boolean hasCycle(ListNode head) {  // trivial solution, N
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
                return true;
        }
        return false;
    }
}
