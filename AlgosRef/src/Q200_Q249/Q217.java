package Q200_Q249;

import java.util.HashSet;
import java.util.Set;

public class Q217 {
    public boolean containsDuplicate(int[] nums) { // no tricks, N
        if(nums==null)
            return false;
        Set<Integer> set = new HashSet<>();
        for(int v : nums) {
            if(set.contains(v))
                return true;
            else {
                set.add(v);
            }
        }
        return false;
    }
}
