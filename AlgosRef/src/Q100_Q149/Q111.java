package Q100_Q149;

import ds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q111 {
    public int minDepth(TreeNode root) {  //N, did it right the first time, 100%, used a BFS approach
        if(root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(queue.size()>0) {
            level++;  // advance here as required level by question
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode n = queue.poll();
                if(n.left==null && n.right==null)  // return from the first found leaf
                    return level;
                if(n.left!=null)
                    queue.offer(n.left);
                if(n.right!=null)
                    queue.offer(n.right);
            }
        }
        return level;
    }
}
