package Q100_Q149;

import static ds.ArrayUtil.printArray;

public class Q189 {
    public void rotate(int[] nums, int k) {  // in place N, this is a very good solution, simple and important
        if(nums==null)
            return;
        k = k%nums.length;  // added this step to handle k>n case; be mindful because the k-1 is used as an index to operate, so here must do a conversion
        rotate(nums, 0, nums.length-1);
        rotate(nums, 0, k-1);
        rotate(nums, k, nums.length-1);
    }

    void rotate(int[] nums, int start, int end) {
        while(start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5,6,7};
        new Q189().rotate(input, 3);
        printArray(input);

        input = new int[]{1};
        new Q189().rotate(input, 2);
        printArray(input);
    }
}
