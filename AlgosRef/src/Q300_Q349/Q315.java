package Q300_Q349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q315 {  // 这个题我的意思是build 一个sorted list，但时间会变成n, 还有一些做法是用merge count,我不是很喜欢，但以后可以了解一下
    // 下面这个解法是build了一个新的BST，我感觉非常的好
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> res = Arrays.asList(new Integer[n]);
        if (n == 0) return res;

        // initialize the end node
        res.set(n-1, 0);
        Node root = new Node(nums[n-1]);

        // traverse from right to left O(n)
        for (int i = n-2; i >= 0; i--) {
            int current = nums[i];

            // track how many values current is greater than
            int gtCount = 0;

            // BST insertion, find parent and count nodes O(log(n))
            Node child = root;
            Node parent = null;
            while (child != null) {
                parent = child;
                if (current < child.val) {
                    // child is greater than this value
                    child.gtCount++;
                    child = child.left;
                } else {
                    // current is greater than all of child's gtCount
                    gtCount += child.gtCount;
                    if (current > child.val) gtCount += 1;
                    child = child.right;
                }
            }

            // insert current node
            if (parent.val > current) {
                parent.left = new Node(current);
            } else {
                parent.right = new Node(current);
            }

            // build result
            res.set(i, gtCount);
        }

        return res;
    }

    class Node {
        Node right, left;
        int val, gtCount;
        public Node(int val) {
            this.val = val;
            this.gtCount = 0;
        }
    }


    public static void main(String[] args) {
        int[] input = new int[] {7,2,3,5,4};
        System.out.println(new Q315().countSmaller(input));
    }

}
