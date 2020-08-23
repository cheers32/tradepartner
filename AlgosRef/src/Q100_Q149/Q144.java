package Q100_Q149;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q144 {  // N, very simple
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode n = stack.pop();
            if(n==null)  // can put null check here
                continue;
            res.add(n.val);
            stack.push(n.right);  // must be right first, because want to access left first
            stack.push(n.left);
        }
        return res;
    }
}
