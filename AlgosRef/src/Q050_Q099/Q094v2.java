package Q050_Q099;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q094v2 {  // another useful in-order traveral algo, N, N space
    public List<Integer> inorderTraversal(TreeNode root) {  // Morris traversal, linked list approach, iterative approach, not necessary a BST
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {  // notice this has to be OR
            while(cur != null) {
                stack.push(cur);  // push all current while going to left
                cur = cur.left;
            }
            cur = stack.pop();  // on leftmost, do the pop and add to result, then go to right
            res.add(cur.val);
            cur = cur.right;
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
        System.out.println(new Q094v2().inorderTraversal(n1));
    }
}
