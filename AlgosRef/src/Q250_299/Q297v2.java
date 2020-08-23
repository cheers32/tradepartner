package Q250_299;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q297v2 {  // this v2 DFS solution is better than v1, because it uses less space, N; will binary half build better than this? i think cut in half won't work, must have inorder+preorder to work
    int start = 0;
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        List<String> list = new ArrayList<>();
        build(root, list);
        return String.join(",",list);
    }

    void build(TreeNode node, List<String> res) {  // this is preorder, but inorder and postorder should also work
        if(node==null) {
            res.add("#");
            return;
        }
        res.add(String.valueOf(node.val));  // cannot skip leaf level coding, otherwise cannot parse
        build(node.left, res);
        build(node.right, res);
    }

    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0)
            return null;
        String[] arr = data.split(",");
        TreeNode res = parse(arr);
        return res;
    }

    TreeNode parse(String[] arr) {
        if(start>arr.length-1)
            return null;
        String s = arr[start];
        start++;
        if(s.equals("#"))
            return null;
        TreeNode n = new TreeNode(Integer.valueOf(s));
        n.left = parse(arr);
        n.right = parse(arr);
        return n;
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
        String res = new Q297v2().serialize(n1);
        System.out.println(res);
        TreeNode n = new Q297v2().deserialize(res);
        System.out.println(n);
    }
}
