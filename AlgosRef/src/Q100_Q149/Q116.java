package Q100_Q149;

import ds.TreeLinkNode;

public class Q116 { //这个题就是找例子，找到普遍现象后试着连一下，最后就是一个先序遍历，　Ｎ; 这个题用ＢＦＳ就是ｔｒｉｖｉａｌ
    public TreeLinkNode connect(TreeLinkNode root) {
        build(root);
        return root;
    }

    void build(TreeLinkNode n) {
        if(n==null)
            return;
        if(n.left!=null)
            n.left.next = n.right;
        if(n.right!=null)
            if(n.next!=null)
                n.right.next = n.next.left;
        build(n.left);
        build(n.right);
    }
}
