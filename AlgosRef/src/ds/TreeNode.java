package ds;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int n) {
        this.val = n;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
