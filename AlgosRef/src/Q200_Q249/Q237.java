package Q200_Q249;

import ds.ListNode;

public class Q237 {
    public void deleteNode(ListNode node) { // O(1) trick, trivial
        if(node==null || node.next==null)  // what to do if node is last (problem says won't be tail)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
