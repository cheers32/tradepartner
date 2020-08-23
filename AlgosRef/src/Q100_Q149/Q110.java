package Q100_Q149;

import ds.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q110 {
    Map<TreeNode, Integer> depthMap = new HashMap<>();  // this cached approach is very slow

    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        if(Math.abs(getDepth(root.left, depthMap)-getDepth(root.right, depthMap))>1)
            return false;
        if(!isBalanced(root.left) || !isBalanced(root.right))
            return false;
        return true;
    }

    int getDepth(TreeNode n, Map<TreeNode, Integer> dep) {
        if(n==null)
            return 0;
        if(dep.containsKey(n)) {
            return dep.get(n);
        }
        int depth = Math.max(getDepth(n.left, dep), getDepth(n.right, dep))+1;
        dep.put(n, depth);  // don't forget to add to map
        return depth;
    }

    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        n3.left = n9;n3.right=n20; n20.left=n15; n20.right=n7;
        System.out.println(new Q110().isBalanced(n3));
    }
}
