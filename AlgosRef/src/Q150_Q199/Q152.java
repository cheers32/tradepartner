package Q150_Q199;

public class Q152 {
    public int maxProduct(int[] nums) {  // 这个题我并没有按照最大最小的方法做，就是左右各一遍就好了, N time, 1 space
        if(nums==null || nums.length==0)
            return 0;
        int max = Integer.MIN_VALUE;  // set this as min value after checking empty input; so that make sure single neg input gets correct value
        int cur = 1;  // init as 1
        for(int i=0; i<nums.length; i++) {
            cur *= nums[i];
            if(cur>max)
                max = cur;
            if(cur == 0) // 这个也是我想出的，一旦是0, 则重置为１
                cur = 1;
        }
        cur = 1;  // important: must update this back to 1, must test use cases to find out
        for(int i= nums.length-1; i>=0; i--) {
            cur *= nums[i];
            if(cur>max)
                max = cur;
            if(cur == 0)
                cur = 1;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[] {2,3,-2,4};
        System.out.println(new Q152().maxProduct(input));
    }
}
