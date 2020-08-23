package Q250_299;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q297v3 {  // the BFS solution is used in TreeUtil
    public String serialize(TreeNode root) {  // this is same solution for Q297v3, BFS solution, same as leetcode standard encoding
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<String> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            List<String> cur = new ArrayList<>();
            boolean isBottom = true;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode n = queue.poll();
                if(n==null) {
                    cur.add("#");
                    //list.add("#");
                    continue;
                }
                if(isBottom) isBottom = false;
                cur.add(String.valueOf(n.val));
                //list.add(String.valueOf(n.val));
//                if(n.left==null && n.right==null)
//                    continue;
                queue.offer(n.left);
                queue.offer(n.right);
            }
            if(!isBottom)
                list.addAll(cur);
        }
        String res = String.join(",", list);
        return res;
    }

    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0)   // here just handling empty string situation
            return null;
        String[] arr = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        if(arr.length==0 || arr[0].equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        queue.offer(root);
        for(int i=1; i<arr.length; i++) {  // this thought process for BFS is important, looping through array and enqueue the current built nodes to do level order traversal
            TreeNode node = queue.poll();
            String v = arr[i];
            if(!v.equals("#")) {
                TreeNode left = new TreeNode(Integer.valueOf(v));
                node.left = left;
                queue.offer(left);
            }
            i++;
            if(i>=arr.length)  // this condition is not necesary for this problem, because it has to be a paired input for each node
                break;
            String v2 = arr[i];
            if(!v2.equals("#")) {
                TreeNode right = new TreeNode(Integer.valueOf(v2));
                node.right = right;
                queue.offer(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n3.left= n4;
        n4.right = n5;
        String res = new Q297v3().serialize(n1);
        System.out.println(res);
        TreeNode n = new Q297v3().deserialize(res);
        System.out.println(n);
    }
}
