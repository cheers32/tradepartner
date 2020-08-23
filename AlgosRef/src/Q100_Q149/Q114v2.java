package Q100_Q149;

import ds.TreeNode;

public class Q114v2 {
    TreeNode pre = null;

    public void flatten(TreeNode root) {  // N, this can be reduced to a very simplle solution
        if(root==null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right=pre;  // this pre is the previously visited node, it's reversely using preorder attribute
        root.left=null;
        pre = root;
    }
}
