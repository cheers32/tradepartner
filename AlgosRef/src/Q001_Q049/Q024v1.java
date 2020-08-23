package Q001_Q049;

import ds.ListNode;

public class Q024v1 {
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        ListNode res = new ListNode(-1);
        res.next = head;  // this problem needs to set a new head, so a dummy head needs to point to current valid head at init, because cur needs to be at this node
        ListNode cur = res;
        while(cur.next != null && cur.next.next != null) {
            ListNode front = cur.next;
            ListNode back = front.next;
            ListNode nextGroup = back.next;
            back.next = front;
            front.next = nextGroup;
            cur.next = back;
            cur = front;
        }
        return res.next;
    }
}
