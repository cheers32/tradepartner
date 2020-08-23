package Q150_Q199;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode n = queue.poll();
                if(i==size-1)
                    res.add(n.val);
                if(n.left!=null)
                    queue.offer(n.left);
                if(n.right!=null)
                    queue.offer(n.right);
            }
        }
        return res;
    }
}
