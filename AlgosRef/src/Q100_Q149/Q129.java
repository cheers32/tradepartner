package Q100_Q149;

import ds.TreeLinkNode;
import ds.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Q129 {
        public int sumNumbers(TreeNode root) {  // N， 仔细想一下不要直接就去写结论; 这次用DFS写对了
            if (root == null)
                return 0;
            int res = find(root, 0);
            return res;
        }

        int find(TreeNode n, int current) {
            if(n.left==null && n.right==null) {  // 这个base条件，是要判断叶子节点； 要想清楚到底是在哪一步乘以10，这个要在纸上画好
                return current + n.val;
            }
            int left = n.left==null ? 0 : find(n.left, (current+n.val)*10);  // 这里也可以pass in sum*10+n.val, 总之保证和base中一致即可
            int right = n.right==null ? 0 : find(n.right, (current+n.val)*10);  // this is wrong: current*10+n.val
            return left+right;
        }


//    public int sumNumbers(TreeNode root) {
//        if(root==null)
//            return 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        Map<TreeNode, Integer> nodeValMap = new HashMap<>();
//        int res = 0;
//        int level = 0;
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            int sum = 0;
//            for(int i=0; i<size; i++) {
//                TreeNode n = queue.poll();
//                if(n.left==null && n.right==null)
//                    sum+=nodeValMap.get(n)+n.val;
//                else
//                    nodeValMap.put(n, nodeValMap.get())
//            }
//        }
//    }
}
