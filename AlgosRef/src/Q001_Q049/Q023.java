package Q001_Q049;

import ds.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q023 {
    public ListNode mergeKLists(ListNode[] lists) {  // n^k
        if(lists == null || lists.length == 0)
            return null;
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {  // memorize comparator syntax, type is ListNode
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode first : lists) {
            if(first != null)
                pq.offer(first);
        }
        while(pq.size()>0) {
            ListNode top = pq.poll();
            cur.next = top;
            if(top.next != null)  // only add non-null values
                pq.offer(top.next);
            cur = cur.next;
        }
        return res.next;
    }
}
