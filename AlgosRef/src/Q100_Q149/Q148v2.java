package Q100_Q149;

import ds.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q148v2 {
    public ListNode sortList(ListNode head) {  // this idea is simple, especially using a LL to merge is easy, but the implementation may cause error, NLogN
        if(head == null || head.next == null)  // notice this base condition is to return itself; this condition needs 2 checks
            return head;
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }

    ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;  // this requires debug to find out
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    ListNode merge(ListNode left, ListNode right) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while(left!=null && right!=null) {
            if(left.val<right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next; //forgot this advance
        }
        if(left!=null)
            cur.next = left;
        if(right!=null)
            cur.next = right;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        n4.next = n2;
        n2.next = n1;
        n1.next = n3;
        new Q148v2().sortList(n1);
        System.out.println(n1);
    }

}
