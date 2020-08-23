package ds;

import Q250_299.Q297v3;

public class TreeUtil {
    public static String serializeBinaryTree(TreeNode root) {  // this is same solution for Q297v3, BFS solution, same as leetcode standard encoding
        return new Q297v3().serialize(root);
    }

    public static TreeNode deserializeBinaryTree(String data) {
        return new Q297v3().deserialize(data);
    }

//    TreeNode build(String[] input, int start, int end) {  // notice that this is not binary build won't work, must accompanied by inorder input
//        if(start>end)
//            return null;
//        int midIdx = (start+end)/2;
//        String v = input[midIdx];
//        if(v.equals("#"))
//            return null;
//        TreeNode n = new TreeNode(Integer.valueOf(v));
//        return n;
//
//    }


    public static void main(String[] args) {
        String[] aa = "".split(",");  // notice this will result in a 1 element string array with [0]=""

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n3.left= n4;
        n4.right = n5;
        String res = serializeBinaryTree(n1);
        System.out.println(res);
        TreeNode n = deserializeBinaryTree(res);
        System.out.println(n);
        TreeNode root = TreeUtil.deserializeBinaryTree("5,2,7,#,#,6,8");
        System.out.println(root);
    }
}
