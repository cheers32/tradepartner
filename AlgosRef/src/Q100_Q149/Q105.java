package Q100_Q149;

import ds.TreeNode;

import java.util.*;

public class Q105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {  // did it well, N very important
        if(preorder==null || inorder==null)
            return null;
        Queue<Integer> preorderQueue = new LinkedList<>();
        for(int i : preorder)
            preorderQueue.offer(i);
        Map<Integer, Integer> idxMap = new HashMap<>();  // value, idx, inorder;
        for(int i=0; i<inorder.length; i++) {  //int idx = Arrays.asList(inorder).indexOf(cur);  // instead of list, use map to find idx
            idxMap.put(inorder[i], i);
        }
        TreeNode res = build(preorderQueue, idxMap, 0, inorder.length);
        return res;
    }

    TreeNode build(Queue<Integer> preorderQueue, Map<Integer, Integer> idxMap, int start, int end) {  // no need to pass in inorder array
        if(preorderQueue.isEmpty())  // 2 ending base condition, queue and index
            return null;
        if(start>end)  // this is >, same idx is ok, meaning it's the leaf node
            return null;
        Integer cur = preorderQueue.poll();
        TreeNode node = new TreeNode(cur);  // no need to loop the queue, use preorder queue to crate node is enough
        int idx = idxMap.get(node.val);
        node.left = build(preorderQueue, idxMap, start, idx-1);
        node.right = build(preorderQueue, idxMap, idx+1, end);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        System.out.println(new Q105().buildTree(preorder, inorder));

    }
}
