package Q100_Q149;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) { // N, solved, not difficult
        List<List<Integer>> res = new ArrayList<>();
        search(res, root, sum, 0, new ArrayList<>());
        return res;
    }

    void search(List<List<Integer>> res, TreeNode n, int sum, int current, List<Integer> list) {
        if(n==null)
            return;
        current += n.val;
        list.add(n.val);
        if(current==sum && n.left==null && n.right==null) {
            res.add(list); // no need to return as this is the leaf level
        }
        search(res, n.left, sum, current, new ArrayList<>(list));  // created a new list for next level of recursion
        search(res, n.right, sum, current, new ArrayList<>(list));
    }
}
