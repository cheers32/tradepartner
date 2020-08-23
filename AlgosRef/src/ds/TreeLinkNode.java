package ds;

public class TreeLinkNode {
    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    public TreeLinkNode(int n) {
        this.val = n;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
