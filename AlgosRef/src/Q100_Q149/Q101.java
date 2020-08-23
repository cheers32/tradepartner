package Q100_Q149;

import ds.TreeNode;

public class Q101 {  // solved, N, easy
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isValid(root.left, root.right);
    }

    boolean isValid(TreeNode left, TreeNode right) {
        if(left==null && right==null)  // standard check
            return true;
        if(left==null || right==null)  // standard check
            return false;
        if(left.val!=right.val)
            return false;
        return isValid(left.right, right.left) && isValid(right.right, left.left);
    }
}
