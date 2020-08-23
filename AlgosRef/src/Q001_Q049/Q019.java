package Q001_Q049;

import ds.ListNode;

public class Q019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {  // n
        ListNode fast = head;
        ListNode current = head;
        int fastSteps = 0;
        int count = 0;  // this count is necessary because the removed node could be the head
        while(fast != null && fastSteps <= n) {  // this is <= for fast steps, means fast need to move 1 more step
            fast = fast.next;
            fastSteps++;
            count++;
        }
        while(fast != null) {
            fast = fast.next;
            current = current.next;
            count++;
        }
        if(count == n)  // same for head case
            return head.next;
        current.next = current.next.next;
        return head;
    }
}
