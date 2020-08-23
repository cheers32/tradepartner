package Q200_Q249;

import ds.TreeNode;
import ds.TreeUtil;

import java.util.Stack;

public class Q230v2 {
    public int KthSmallest(TreeNode root, int k) { // 再复习一下用stack写dfs的方法, also a N time solution, pretty good
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;
        while(node!=null) {
            stack.push(node);
            node = node.left;
        }
        while(k>0 && !stack.isEmpty()) {  // added stack empty check, along with k>0
            TreeNode n = stack.pop();
            k--;
            if(k==0)
                return n.val;
            TreeNode right = n.right;
            while(right!=null) {
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserializeBinaryTree("3,1,4,#,2");
        System.out.println(new Q230v2().KthSmallest(root, 5));
    }
}
