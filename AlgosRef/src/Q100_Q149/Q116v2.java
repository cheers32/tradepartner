package Q100_Q149;

import ds.TreeLinkNode;

public class Q116v2 {
    public TreeLinkNode connect(TreeLinkNode root) { // BFS, N, iteration approach
        TreeLinkNode node = root;
        while(node != null) {
            TreeLinkNode cur = node;
            while (cur != null) {  // this is same as recursion
                if (cur.left != null)
                    cur.left.next = cur.right;
                if (cur.right != null) {
                    if (cur.next != null)
                        cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            node = node.left;  // always starts from leftmost of each level
        }
        return root;
    }
}
