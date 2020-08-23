package Q100_Q149;

import ds.TreeLinkNode;
import ds.TreeNode;

public class Q124 {  // this is a DFS solution, N, the approach is important
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        build(root);
        return maxValue;
    }

    int build(TreeNode node) {
        if(node == null)
            return 0;
        int left = Math.max(0,build(node.left));  // each side getting positive values
        int right = Math.max(0, build(node.right));
        int curMax = left+right+node.val;
        maxValue = Math.max(curMax, maxValue);  // separately updating the current chain
        return Math.max(left, right)+node.val;  // and then pass the single chain result
    }


    public int maxPathSum_wrong(TreeNode root) {
        if(root==null)
            return Integer.MIN_VALUE;
        if(root.left==null && root.right==null)
            return root.val;
        int left = maxPathSum_wrong(root.left);
        int right = maxPathSum_wrong(root.right);
        return Math.max(root.val, Math.max(left+right+root.val, Math.max(left, right)));
    }
}
