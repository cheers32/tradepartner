package Q150_Q199;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199v2 {
    public List<Integer> rightSideView(TreeNode root) {  // N, constant space, recursive approach, this is a better approach
        if(root == null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        visit(root, 0, res);
        return res;
    }

    void visit(TreeNode node, int level, List<Integer> res) {
        if(node == null)
            return;
        if(level == res.size()) {
            res.add(node.val);
        }
        visit(node.right, level+1, res);  // good trick, first branch to right
        //if(level == res.size())
        visit(node.left, level+1, res);  // looks like cannot skip left branch on condition
    }
}
