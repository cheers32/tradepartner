package Q250_299;

import ds.TreeNode;
import ds.TreeUtil;

public class Q298 {
    public int longestConsecutive(TreeNode root) {
        if(root == null)
            return 0;
        return search(root, 1, root.val);
    }

    int search(TreeNode node, int cur, int parentVal) {
        if(node==null)
            return cur;
        int left = 0;
        int right = 0;
        if(node.val==parentVal+1) {
            left = search(node.left, cur+1, node.val);
            right = search(node.right, cur+1, node.val);

        } else {
            left = search(node.left, 1, node.val);  // this was errored, i passed in cur, but on paper i put 1 to pass, meaning current longest is 1
            right = search(node.right, 1, node.val);
        }
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
        System.out.println(new Q298().longestConsecutive(root));
        input = "2,#,3,2,#,1";
        root = TreeUtil.deserializeBinaryTree(input);
        System.out.println(root);
        System.out.println(new Q298().longestConsecutive(root));
        input = "1,2,3,4,5";
        root = TreeUtil.deserializeBinaryTree(input);
        System.out.println(new Q298().longestConsecutive(root));
    }
}
