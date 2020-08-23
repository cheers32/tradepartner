package Q001_Q049;

public class Q035 {
    public int searchInsert(int[] nums, int target) {  // logN, very simple solution, just the start idx. must try multiple cases; no need to do adjustment on index, no need to handle both ends case
        int start = 0;
        int end = nums.length-1;
        while(start<=end) {
            int mIdx = (start+end)/2;
            if(target == nums[mIdx])
                return mIdx;
            if(nums[mIdx]<target) {
                start=mIdx+1;
            }
            else
                end=mIdx-1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,3,5,6};
        System.out.println(new Q035().searchInsert(input, 5));
        System.out.println(new Q035().searchInsert(input, 2));
        System.out.println(new Q035().searchInsert(input, 7));
        System.out.println(new Q035().searchInsert(input, 0));
    }
}
