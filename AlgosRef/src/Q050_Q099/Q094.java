package Q050_Q099;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q094 {  // very interesting in-order traveral algo, N, Threaded Binary Tree
    public List<Integer> inorderTraversal(TreeNode root) {  // Morris traversal, linked list approach, iterative approach, not necessary a BST
        List<Integer> res = new ArrayList<>();
        while(root != null) {
            if(root.left == null) {  // a) Add current’s value b) Go to the right
                res.add(root.val);
                root = root.right; // branch to right if left is null
            } else {
                TreeNode prev= root.left;
                TreeNode temp = prev;
                while(prev.right!=null) {  // dfs to left's right most, must be prev to move, so that it can connect to root
                    prev = prev.right;
                }
                prev.right = root;  // use right as next pointer, left as previous pointer
                root.left = null;
                root = temp;  // from text: a) In current's left subtree, make current the right child of the rightmost node; b) Go to this left child
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        System.out.println(new Q094().inorderTraversal(n1));
    }
}
