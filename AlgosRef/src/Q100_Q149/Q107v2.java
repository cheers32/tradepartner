package Q100_Q149;

import ds.TreeNode;

import java.util.*;

public class Q107v2 {  // N, this is DFS approach, using a list like a map for corresponding level
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        build(root, res, 0);
        Collections.reverse(res);
        return res;
    }

    void build(TreeNode node, List<List<Integer>> res, int level) {
        if(node == null)
            return;
        if(level>=res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        build(node.left, res, level+1);
        build(node.right, res, level+1);
    }
}
