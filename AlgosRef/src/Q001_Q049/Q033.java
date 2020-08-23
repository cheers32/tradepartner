package Q001_Q049;

public class Q033 {
    // binary search is one of the most critical skill, must be able to write without thinking
    // 2 important points: 1. start = mIdx+1 to avoid missed search; 2. always use <=  on two ends to avoid missed search; 3. the left ordered range must use <= check
    public int search(int[] nums, int target) {  // logN
        if(nums==null || nums.length==0)
            return -1;
        int start = 0;
        int end = nums.length-1;
        while(start<=end) {
            int mIdx = (start+end)/2;
            if(nums[mIdx]==target) {
                return mIdx;
            }
            if(nums[start]<=nums[mIdx]) {  // left is sorted; this must be <= condition! because we use start=mIdx+1 (with extra advance on start)
                if(target >= nums[start] && target < nums[mIdx]) { // target in range
                    end=mIdx;
                }
                else {
                    start=mIdx+1;
                }
            } else {  // right is sorted; note that use "else" is correct, because it specifies the other range
                if(target>nums[mIdx] && target<=nums[end]) { // target in range
                    start = mIdx+1;
                }
                else {
                    end = mIdx;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = new int[] {3,4,5,6,1,2};
        System.out.println(new Q033().search(input, 0));
        input = new int[] {1,3};
        System.out.println(new Q033().search(input, 0));
        input = new int[] {4,5,6,7,0,1,2};
        System.out.println(new Q033().search(input, 0));
    }
}
