package Q150_Q199;

public class Q153 {
    public int findMin(int[] nums) { // LogN, my solution is correct, always go to the un-ordered half, to find the pivot
        int start = 0;
        int end = nums.length-1;  // notice this has to be len-1, because this idx will be used for access
        while(start<end) { // as default, < is ok
            // add this condition to return final result
            if(nums[start]<nums[end])  // this condition is important, as final determination
                return nums[start];
                // return nums[end];  // this is used to find the max
            int midIdx = (start+end)/2;
            int midVal = nums[midIdx];
            //if(nums[start]<midVal) {  // use start to compare to find max; note that this is used to find the max; earlier i thought this condition cannot determine right is unordered
            if(nums[end]<midVal) {  // use end to compare mid to find min; search right, this says right is unordered
                start = midIdx + 1;
                //} else if(nums[end]>midVal){  // this is redundant
            } else {
                end = midIdx;
            }
        }
        return nums[start];  // any +1 type of adjustment will cause overflow, so don't use; start or end both ok
    }

    public static void main(String[] args) {
        int[] input = new int[]{6,1,2,3,4,5};
        System.out.println(new Q153().findMin(input));
        int[] input2 = new int[]{3,4,5,6,1,2};  // design 2 cases
        System.out.println(new Q153().findMin(input2));
        int[] input3 = new int[]{1,2,3,4,5,6};
        System.out.println(new Q153().findMin(input3));
        int[] input4 = new int[]{2};
        System.out.println(new Q153().findMin(input4));
    }
}
