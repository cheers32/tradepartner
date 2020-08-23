package ds;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int n) {
        this.val = n;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
