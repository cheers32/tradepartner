package Q050_Q099;

import ds.ListNode;

public class Q082 {  // N, good solution, made a few mistakes
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;  // must link init
        ListNode pre = dummyHead;  // standard init
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            ListNode next = cur.next;
            if(next.val != cur.val) {
                pre = cur;   // only advancing pre when confirmed not same
                cur = next;
            } else {
                while(next != null && next.val == cur.val) {  // advance next
                    next = next.next;
                }
                pre.next = next;
                //pre = next;  // cannot advance pre here
                cur = next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        n1.next=n2; n2.next=n3; n3.next=n4; n4.next=n5;
        ListNode res = new Q082().deleteDuplicates(n1);
        System.out.println(res);
    }
}
