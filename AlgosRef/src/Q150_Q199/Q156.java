package Q150_Q199;

import ds.TreeNode;
import ds.TreeUtil;

public class Q156 {  // N, recursion, 这个题看上去像是线段树的做法,就是先找到规律，然后考虑base case以及返值。这个题的要点在于只向左走，并且要先走; 这个题先存下做没有用，因为左的两个子节点都变化了
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null || root.left==null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserializeBinaryTree("1,2,3,4,5");
        TreeNode res = new Q156().upsideDownBinaryTree(root);
        System.out.println(TreeUtil.serializeBinaryTree(res));
    }
}
