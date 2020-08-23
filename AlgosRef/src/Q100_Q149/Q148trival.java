package Q100_Q149;

import ds.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q148trival {
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        ListNode cur = head;
        while(cur!=null) {
            list.add(cur.val);
            cur = cur.next;
        }
        Collections.sort(list);
        cur = head;
        for(Integer v : list) {
            cur.val = v;
            cur = cur.next;
        }
        return head;
    }
}
