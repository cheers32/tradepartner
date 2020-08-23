package Q100_Q149;

import ds.TreeNode;

public class Q112 {
    public boolean hasPathSum(TreeNode root, int sum) { // N, simple solution
        return search(root, sum, 0);
    }

    boolean search(TreeNode n, int sum, int current) {
        if(n==null)
            return false;
        current += n.val;
        if(current==sum && n.left==null && n.right==null)  // remember the requirement is the leaf node
            return true;
        return search(n.left, sum, current) || search(n.right, sum, current);
    }
}
