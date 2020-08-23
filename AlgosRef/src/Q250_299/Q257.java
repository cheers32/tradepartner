package Q250_299;

import ds.TreeNode;
import ds.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class Q257 {
    public List<String> binaryTreePaths(TreeNode root) {  // N, 通过了, debug了几次，应该一次过的
        if(root == null)
            return new ArrayList<>();
        List<String> res = new ArrayList<>();
        dfs(root, res, new ArrayList<>());
        return res;
    }

    void dfs(TreeNode n, List<String> res, List<Integer> s) {
        if(n.left==null && n.right==null) { // corrected:　这一步不需要检验，但是要加入自己的值；这里的base case我用的是叶子节点
            s.add(n.val);
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.size(); i++) {
                sb.append(s.get(i));
                if(i!=s.size()-1)
                    sb.append("->");
            }
            res.add(sb.toString());  // corrected:　忘记了这一步，不应该
        }
        if(n.left!=null) {
            List<Integer> newList = new ArrayList<>(s); //我还是更习惯于这种在branch前新建的方法，相对于backtracking的revert，然后在进res前再新建，那种适合于不一定每个branch都有结果的情况
            newList.add(n.val);
            dfs(n.left, res, newList);
        }
        if(n.right!=null) {
            List<Integer> newList = new ArrayList<>(s);
            newList.add(n.val);
            dfs(n.right, res, newList);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserializeBinaryTree("1,2,3,#,5");
        System.out.println(new Q257().binaryTreePaths(root));
    }
}
