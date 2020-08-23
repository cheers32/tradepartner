package Q100_Q149;

public class Q136 {
    public int singleNumber(int[] nums) { // trival problem, N
        int res = 0;
        for(int n : nums)
            res ^= n;
        return res;
    }
}
