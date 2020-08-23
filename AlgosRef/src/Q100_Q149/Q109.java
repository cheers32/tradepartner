package Q100_Q149;

import ds.ListNode;
import ds.TreeNode;

public class Q109 {
    public TreeNode sortedListToBST(ListNode head) {  //N, easy, and good solution
        if(head==null)
            return null;
        return build(head, null);  // passing end as null is ok, because first round the end is null
    }

    TreeNode build(ListNode start, ListNode end) {
//        if(start == null || end == null)
//            return null;
        if(start==end)  // this ending condition is important
            return null;
        ListNode fast = start;
        ListNode target = start;
        while(fast!=end && fast.next!=end) {  // don't make this wrong, it is !=end, not !=null
            target = target.next;
            fast = fast.next.next;
        }
        TreeNode n = new TreeNode(target.val);
        n.left = build(start, target);
        n.right = build(target.next, end);
        return n;
    }
}
