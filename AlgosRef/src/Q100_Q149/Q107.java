package Q100_Q149;

import ds.TreeNode;

import java.util.*;

public class Q107 { // N, trival. if using recursion, it is used like a map to update the list of corresponding level
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            res.add(list);
        }
        Collections.reverse(res);  // only 1 reverse on final result is needed
        return res;
    }
}
