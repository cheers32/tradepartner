package Q250_299;

import ds.TreeNode;
import ds.TreeUtil;

public class Q298improve {  // N time, simple question, but found a serious common mistake, must notice
    public int longestConsecutive(TreeNode root) {
        if(root == null)
            return 0;
        return search(root, 1, root.val);
    }

    int search(TreeNode node, int cur, int parentVal) {  // made a mistake by changing the cur to pass, but later comparison caused error; // this type of error must be avoided! must check if input value is used before changing, otherwise use a new value
        if(node==null)
            return cur;
        int left = 0;
        int right = 0;
        int newLen = node.val==parentVal+1 ? cur+1 : 1; // meaning the consecutive is broken now, set to 1; the error also comes from set cur to 0 thought; use a new value is always safe!
        left = search(node.left, newLen, node.val);  // the error comes when i changed code from previous version
        right = search(node.right, newLen, node.val);
        return Math.max(cur, Math.max(left, right));
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.right = n3;
        n3.left = n2;
        n3.right = n4;
        n4.right = n5;
        System.out.println(TreeUtil.serializeBinaryTree(n1));

        String input = "1,#,3,2,4,#,#,#,5";
        TreeNode root = TreeUtil.deserializeBinaryTree(input);
        System.out.println(root);
        System.out.println(new Q298improve().longestConsecutive(root));
        input = "2,#,3,2,#,1";
        root = TreeUtil.deserializeBinaryTree(input);
        System.out.println(root);
        System.out.println(new Q298improve().longestConsecutive(root));
        input = "1,2,3,4,5";
        root = TreeUtil.deserializeBinaryTree(input);
        System.out.println(new Q298improve().longestConsecutive(root));
    }
}
