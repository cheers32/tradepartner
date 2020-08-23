package Q100_Q149;

import ds.TreeNode;

public class Q110v2 {
    public boolean isBalanced(TreeNode root) {  // N, this is the best approach, do the depth count and balance check at the same node same time; no need to use a cache
        if(root == null)
            return true;
        return getDepth(root)!=-1;
    }

    int getDepth(TreeNode n) {
        if(n==null)
            return 0;
        int left = getDepth(n.left);
        int right = getDepth(n.right);
        if(left==-1 || right==-1 || Math.abs(left-right)>1)
            return -1;
        return Math.max(left, right)+1;
    }
}
