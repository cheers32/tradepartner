package Q200_Q249;

import ds.TreeNode;

public class Q226 {
    public TreeNode invertTree(TreeNode root) { // N, trival, no trick
        if(root == null)
            return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
