package Q200_Q249;

import ds.TreeNode;

public class Q236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { // N, this is a very good problem, i solved it myself this time
        if(root==null)
            return null;
        if(root==p || root==q)  // this way all the recursion below is stopped, because this is the lowest
            return root;  // this also means, even one of the pq not in tree, still one of them is returned
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left==null && right==null)
            return null;
        if(left!=null && right!=null)
            return root;
        if(left==null)
            return right;
        else
            return left;
    }
}
