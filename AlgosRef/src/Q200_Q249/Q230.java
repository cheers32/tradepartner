package Q200_Q249;

import ds.TreeNode;
import ds.TreeUtil;

public class Q230 {
    public int KthSmallest(TreeNode root, int k) { // my approach is correct; it's also fast, the time is N, or better to say K
        int[] res = new int[1];
        dfs(root, new int[]{k}, res);  // but since i don't know the size of the entire tree, so it is still N
        return res[0];
    }

    void dfs(TreeNode n, int[] k, int[] res) {
        if(n==null)
            return;
        dfs(n.left, k, res);
        k[0]--;
        if(k[0]==0) {
            res[0] = n.val;
            return;
        }
        dfs(n.right, k, res);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserializeBinaryTree("3,1,4,#,2");
        System.out.println(new Q230().KthSmallest(root, 5));
    }
}
