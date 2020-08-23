package Q200_Q249;

import ds.ListNode;

public class Q234 {
    public boolean isPalindrome(ListNode head) {  // N, very easy solution, just one adjustment, and one backtrack end conditions to notice
        ListNode fast = head;
        ListNode n = head;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            n = n.next;
        }
        // one step to adjust the n: for odd case
        if(fast!=null) {
            n = n.next;
        }
        ListNode newHead = reverse(n);
        n = head;
        while(newHead!=null) {  // here since after reverse, the end is a null, so only use this as the end condition to run
            if(newHead.val!=n.val)
                return false;
            newHead = newHead.next;
            n = n.next;
        }
        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null;
        while(head!=null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
