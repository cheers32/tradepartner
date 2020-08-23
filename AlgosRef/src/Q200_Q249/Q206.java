package Q200_Q249;

import ds.ListNode;

public class Q206 {
    public ListNode reverseList(ListNode head) {  // N, simple iteration
        ListNode prev = null;
        while(head!=null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverseList_Recur(ListNode head) {  // N, simple solution
        if(head == null || head.next == null)
            return head;
        ListNode next = head.next;
        ListNode newHead = reverseList_Recur(head.next);
        next.next = head;
        head.next = null;  // added this for the last node to be able to unlink
        return newHead;
    }
}
