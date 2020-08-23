package Q150_Q199;

public class Q162 {
    public int findPeakElement(int[] nums) {  // logN, 这个题做起来感觉一般,解法比较特别;因为题目只需找到一个结果即可,所以用二叉搜索,比较巧妙
        int start = 0;
        int end = nums.length-1;
        while(start<end) {
            int midIdx = (start+end)/2;
            if((midIdx==0 || nums[midIdx]>nums[midIdx-1]) && nums[midIdx]>nums[midIdx+1])
                return midIdx;
            else if(nums[midIdx]>nums[midIdx+1])
                end = midIdx-1;
            else
                start = midIdx+1;
        }
        return end;
    }
}
