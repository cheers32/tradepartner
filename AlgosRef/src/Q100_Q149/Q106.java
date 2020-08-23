package Q100_Q149;

import ds.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Q106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {  // N, similary to 105, 3 differences
        if(inorder==null || postorder==null)
            return null;
        Queue<Integer> postorderQueue = new LinkedList<>();
        for(int i=postorder.length-1; i>=0; i--)  // inverse enqueue postorder
            postorderQueue.offer(postorder[i]);
        Map<Integer, Integer> idxMap = new HashMap<>();  // value, idx, inorder;
        int idx = inorder.length-1;
        for(Integer i : inorder) {  // make inorder index reverse
            idxMap.put(i, idx--);
        }
        TreeNode res = build(postorderQueue, idxMap, 0, inorder.length);
        return res;
    }

    TreeNode build(Queue<Integer> postorderQueue, Map<Integer, Integer> idxMap, int start, int end) {
        if(postorderQueue.isEmpty())
            return null;
        if(start>end)
            return null;
        Integer cur = postorderQueue.poll();
        TreeNode node = new TreeNode(cur);
        int idx = idxMap.get(node.val);
        node.right = build(postorderQueue, idxMap, start, idx-1);  // build right first
        node.left = build(postorderQueue, idxMap, idx+1, end);
        return node;
    }

    public static void main(String[] args) {
        int[] inorder = new int[] {9,3,15,20,7};
        int[] postorder = new int[] {9,15,7,20,3};
        System.out.println(new Q106().buildTree(inorder, postorder));
    }
}
