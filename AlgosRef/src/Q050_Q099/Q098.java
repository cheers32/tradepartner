package Q050_Q099;

import ds.TreeNode;

public class Q098 {
    public boolean isValidBST(TreeNode root) {  // N, standard solution
        return validate(root, Long.MAX_VALUE, Long.MIN_VALUE); // using long is also to fit this problem
    }

    boolean validate(TreeNode node, long max, long min) {
        if(node == null)
            return true;
        if(node.val <= min || node.val >= max)  // this is particular for this problem, same value is not valid
            return false;
        if(!validate(node.left, node.val, min))
            return false;
        if(!validate(node.right, max, node.val))
            return false;
        return true;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n2.left = n1;
        n2.right = n3;
        System.out.println(new Q098().isValidBST(n2));
    }
}
