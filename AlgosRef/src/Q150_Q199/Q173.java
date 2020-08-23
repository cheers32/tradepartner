package Q150_Q199;

import ds.TreeNode;
import ds.TreeUtil;

import java.util.Stack;

public class Q173 {  // log(N) next, O(1) hasnext; 这个是一个非常重要的标准做法；我的那个next successor的做法可以吗？
    static class BSTIterator {
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            pushLeftNodes(root);
            //if(root!=null) {
                //stack.push(root);
                //pushLeftNodes(root.left);
            //}
        }

        void pushLeftNodes(TreeNode n) {
            while(n!=null) {
                stack.push(n);
                n = n.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode top = stack.pop();
            if(top.right!=null) {
                //stack.push(top.right);
                //pushLeftNodes(top.right.left);
                pushLeftNodes(top.right);   // 每次把左边先准备好，就省去了每次check 是否左边已visit的问题
            }
            return top.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
//            if(stack.isEmpty())
//                return false;
//            return true;
        }
    }

    static class BSTIteratorWrong {

        Stack<TreeNode> stack;
        boolean isLeftVisited = false;

        public BSTIteratorWrong(TreeNode root) {
            stack = new Stack<>();
            stack.push(root);
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode top = stack.peek();
            if(isLeftVisited) {
                stack.pop();
                if(top.right!=null)
                    stack.push(top.right);
                isLeftVisited = false;
                return top.val;
            }
            else {
                TreeNode n = top;
                while(n.left!=null) {
                  n = n.left;
                  stack.push(n);
                }
                stack.pop();
                if(n.right!=null)
                    stack.push(n.right);
                isLeftVisited = true;
                return n.val;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if(stack.isEmpty())
                return false;
            return true;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserializeBinaryTree("5,2,7,#,#,6,8");
        //TreeNode root = TreeUtil.deserializeBinaryTree("3,1,4,#,2");
        //System.out.println(root);
        BSTIterator algo = new BSTIterator(root);
        while(algo.hasNext())
            System.out.println(algo.next());
//        System.out.println(algo.next());
//        System.out.println(algo.next());
//        System.out.println(algo.next());
//        System.out.println(algo.next());
        //System.out.println(algo.next());
        //System.out.println(algo.next());

    }
}
