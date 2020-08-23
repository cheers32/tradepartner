package Q001_Q049;

import ds.ListNode;

public class Q021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) { // l1+l2
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while(l1!=null && l2!=null) {
            // cur.next = l1.val<l2.val ? l1 : l2; also need to advance l1 or l2
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;  // don't forget to advance l1 l2
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next; // forgot to advance; wrongly used res, not cur

        }
        cur.next = l1==null? l2: l1;
        return res.next;
    }
}
