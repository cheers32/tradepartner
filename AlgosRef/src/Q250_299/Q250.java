package Q250_299;

import ds.TreeNode;

public class Q250 {  // N， 这个题过了，我很开心，尽管是看了提示后做出的
    public int countUnivalSubtrees(TreeNode root) {  // 这个题的关键在于一个一个的subtree通过dfs的方式证实，并且通过判断是与否的方式逐层回朔
       if(root == null)  // this check is not necessary
           return 0;
       int[] res = new int[1];
       dfs(root, res);
       return res[0];
    }

    boolean dfs(TreeNode node, int[] res) { // 我第一次考虑返回值，但那样就不好判断返回的值还能不能往上传，相当于下面是否都是完好的这个信息丢掉了
        if(node==null)  // this is used as base case， 这种base case比判断叶子节点那种好用
            return true;
        boolean left = dfs(node.left, res);   // 后序dfs，因为需要两个子节点的结果
        boolean right = dfs(node.right, res);
        if(left && right) {
            if(node.left!=null && node.left.val!=node.val)  // 即使两边都行，但自己这一关必须要数值一致才可
                return false;
            if(node.right!=null && node.right.val!=node.val)
                return false;
            res[0]++;  // 这一步最关键，if both left and right are good, then the result just mean we add one more valid tree
            return true;
        }
        return false;  // 若左右有一个不行，那么就一直不行了，这个条件要早判断清楚
    }

    public int countUnivalSubtrees_wrong(TreeNode root) {
        if(root==null)  // useful for single side null
            return 0;
        if(root.left==null && root.right==null)  // base case
            return 1;
        int left = countUnivalSubtrees_wrong(root.left);
        int right = countUnivalSubtrees_wrong(root.right);

        //if(root.left!=null && root.val==root.left.val && root.right!=null && root.val!=root.right.val)
        //    return 0;
        return 0;
    }
}
