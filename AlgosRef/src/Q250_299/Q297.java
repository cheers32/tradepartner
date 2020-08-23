package Q250_299;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q297 {
    public String serialize(TreeNode root) {  // this version of DFS uses 2N space, N time, v2 is better
        if(root == null)
            return "";
        List<String> list = new ArrayList<>();
        build(root, list);
        return String.join(",",list);
    }

    void build(TreeNode node, List<String> res) {
        if(node==null) {
            res.add("#");
            return;
        }
        res.add(String.valueOf(node.val));
//        if(node.left==null && node.right==null)  // this check will make deserialize not able to proceed
//            return;
        build(node.left, res);
        build(node.right, res);
    }

    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0)
            return null;
        String[] arr = data.split(",");
        List<String> input = new LinkedList<>();
        for(String s : arr)
            input.add(s);
        TreeNode res = parse(input);
        return res;
    }

    TreeNode parse(List<String> data) {  // during parse, maybe i should use a global i, to save space
        if(data.size()==0)
            return null;
        String s = data.remove(0);
        if(s.equals("#"))
            return null;
        TreeNode n = new TreeNode(Integer.valueOf(s));
        n.left = parse(data);
        n.right = parse(data);
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
        String res = new Q297().serialize(n1);
        System.out.println(res);
        TreeNode n = new Q297().deserialize(res);
        System.out.println(n);
    }
}
