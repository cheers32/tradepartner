package Q200_Q249;

import java.util.HashSet;
import java.util.Set;

public class Q246 {
    public boolean isStrobogrammatic(String num) { // N, simple solution
        if(num == null)
            return false;
        int start = 0;
        int end = num.length()-1;
        Set<Character> validSet = new HashSet<>();
        validSet.add('1');validSet.add('6');validSet.add('8');validSet.add('9');validSet.add('0');
        while(start<=end) {  // this <= is good, because want to check the last middle single one
            char v1 = num.charAt(start);
            char v2 = num.charAt(end);
            if(!validSet.contains(v1) || !validSet.contains(v2))  // v2 check is not necessary; corrected case, must check valid, so that 2, 5, 7 won't qualify
                return false;
            if(v1 == '6')  // i thought only need to convert 6 at first, didn't realize both 6 and 9 need to convert
                v1 = '9';
            else if(v1 == '9')  // corrected case, must also change case 9! must try more cases after or before writing; this will also make single char not qualify
                v1 = '6';
            if(v1!=v2)
                return false;
            start++;   // must never forget to advance
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q246().isStrobogrammatic("69"));
        System.out.println(new Q246().isStrobogrammatic("9"));
    }
}
