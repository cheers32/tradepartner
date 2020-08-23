package Q250_299;

import ds.TreeNode;

public class Q270 {
    public int closestValue(TreeNode root, double target) {  // N, 就是一个正常遍历，然后把root节点事先放入，以避免默认的0作为结果输出
        if(root==null)
            return 0;
        int[] res = new int[1];
        res[0] = root.val;
        dfs(root, target, res);
        return res[0];
    }

    void dfs(TreeNode n, double target, int[] res) {
        if(n==null)
            return;
        if(Math.abs(n.val-target)<Math.abs(res[0]-target))
            res[0] = n.val;
        dfs(n.left, target, res);
        dfs(n.right, target, res);
    }
}
