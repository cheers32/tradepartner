package Q250_299;

public class Q268 {
    public int missingNumber(int[] nums) {  // N, trivial, otherwise can use a map to mark
        if(nums==null)
            return 0;
        int expected = (nums.length+1)*nums.length/2;
        for(int v : nums) {
            expected-=v;
        }
        return expected;
    }
}
