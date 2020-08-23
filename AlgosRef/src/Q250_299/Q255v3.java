package Q250_299;

import java.util.Stack;

public class Q255v3 {  // 这个改进方法不好想， 但是很重要，最后形成一个降序的栈 ，N
    // 其实这个题也可以理解为，给定一个preorder,看是否存在valid BST； 原题意是这个sequence是否是valid的，存在valid BST,就必然可以
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null)
            return false;
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;  //从stack中出去了的值就成为了min值，不能比min更小, 表示它左边的都走完了,后面都是右边的
        for(int num : preorder){
            if(stack.isEmpty() || num<stack.peek()){  // 当前数小于栈顶值或栈为空
                if(num<min){  // 在正常进的时候要测一下min，后面那种不可能比min小
                    return false;
                }
                stack.push(num);
            } else{
                while(!stack.isEmpty() && num>stack.peek()){ // 这样就是要把栈底左边的都Pop出去
                    min = stack.pop();
                }
                stack.push(num);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q255v3().verifyPreorder(new int[] {5,2,1,3,6}));
        System.out.println(new Q255v3().verifyPreorder(new int[] {5,2,6,1,3}));
    }
}
