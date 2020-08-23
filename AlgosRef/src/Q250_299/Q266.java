package Q250_299;

import java.util.HashSet;
import java.util.Set;

public class Q266 {
    public boolean canPermutePalindrome(String s) {  // N, very trivial, notice to use a set, a map is not needed
        Set<Character> set = new HashSet<>();
        for(Character c : s.toCharArray()) {
            if(!set.contains(c))
                set.add(c);
            else
                set.remove(c);
        }
        return set.size()<=1;
    }
}
