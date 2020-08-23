package Q100_Q149;

import ds.TreeNode;

public class Q100 { // N, easy problem
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==q)  // including null and same node
            return true;
        if(p==null || q==null)
            return false;
        if(p.val!=q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        System.out.println(null==null);
    }
}
