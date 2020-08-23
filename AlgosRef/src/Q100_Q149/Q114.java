package Q100_Q149;

import ds.TreeNode;

public class Q114 {
    public void flatten(TreeNode root) {
        build(root, null);  // null pre is ok
    }

    TreeNode build(TreeNode node, TreeNode pre) {  // this is a special approach, started from right, then left then self, it is tricky
        if(node==null)
            return pre;  // return pre for null
        pre = build(node.right, pre);
        pre = build(node.left, pre);
        node.right = pre;
        node.left = null;
        pre = node;
        return pre; // returns pre; the pre means last operated node, build from bottom
    }

//    TreeNode build(TreeNode node, TreeNode pre) {  // not working
//        if(node==null)
//            return null;
//        if(node.left==null && node.right==null && pre!=null)
//            pre.right = node;
//        pre = node;
//        TreeNode right = node.right;
//        pre = build(node.left, pre);
//        build(right, pre);
//        node.left = null;
//        return node;
//    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2; n2.left=n3; n2.right=n4; n1.right=n5; n5.right=n6;
        new Q114().flatten(n1);
        System.out.println("done");
    }
}
