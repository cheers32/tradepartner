package Q200_Q249;

import ds.TreeNode;
import ds.TreeUtil;

public class Q235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { // logN， 这个题我开始是想先返回成功条件，但很可能覆盖面不够
        if(root == null || p == null || q==null)  // 这个题虽然时间为N, 但很有可能不用全走完
            return null;
        if(p.val<root.val && q.val<root.val)  // 所以最终调整成两个确定的左和右
            return lowestCommonAncestor(root.left, p, q);
        else if(p.val>root.val && q.val>root.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }

    public TreeNode lowestCommonAncestor_iteration(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q==null)
            return null;
        if(p.val>q.val) {  // this is to swap node, not value
            TreeNode temp = p;
            p = q;
            q = temp;
//            int temp = p.val;
//            p.val = q.val;
//            q.val = temp;
        }
        while(root!=null) {
            if(p.val<=root.val && q.val>=root.val)  // here it requires to be <=
                return root;
            else if(p.val<root.val && q.val<root.val)
                root = root.left;
            else
                root = root.right;
        }
        return null;
    }


    public TreeNode lowestCommonAncestor_wrong(TreeNode root, TreeNode p, TreeNode q) { // i think this assumes p<q (no, no such assumption)
        if(root==null)  // this was wrong because i didn't use >= <= as comparison
            return null;
        if(p.val<=root.val && q.val>=root.val || p.val>=root.val && q.val<=root.val)  // this can also be preprocessed to switch p, q, so that p is always less than q
            return root;
        if(p.val<root.val && q.val<root.val)
            return lowestCommonAncestor_wrong(root.left, p, q);
        else if (p.val>root.val && q.val>root.val)
            return lowestCommonAncestor_wrong(root.right, p, q);
        else
            return null;
    }

    public static void main(String[] args) {
        TreeNode input = TreeUtil.deserializeBinaryTree("6,2,8,0,4,7,9,#,#,3,5");
        //new Q235().lowestCommonAncestor(input, 2, 4);
    }
}
