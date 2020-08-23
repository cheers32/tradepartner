package Q001_Q049;

import ds.ListNode;

public class Q002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {  // m+n
        ListNode head = new ListNode(-1);
        ListNode node = head;
        int carry = 0;
        while(l1!=null || l2!=null) {  // this "or" condition is needed
            ListNode n = new ListNode(-1);
            int v1 = l1!=null ? l1.val:0;  // get each list's value by null checking
            int v2 = l2!=null ? l2.val:0;
            int sum = carry + v1 + v2;
            n.val = sum % 10;
            carry = sum / 10;
            node.next = n;
            node = node.next;
            if(l1 != null) {  // continue with each list
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry>0) {  // need last step
            ListNode n = new ListNode(1);
            node.next = n;
        }
        return head.next;
    }
}
