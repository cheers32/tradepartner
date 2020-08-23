package Q100_Q149;

import ds.TreeNode;

public class Q108 {  // N, easy, first try and passed
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0)
            return null;
        return build(nums, 0, nums.length-1);
    }

    TreeNode build(int[] nums, int start, int end) {
        if(start>end)
            return null;
        int mIdx = (start+end)/2;
        TreeNode n = new TreeNode(nums[mIdx]);
        n.left = build(nums, start, mIdx-1);
        n.right = build(nums, mIdx+1, end);
        return n;
    }
}
