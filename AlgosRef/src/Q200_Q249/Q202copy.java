package Q200_Q249;

import java.util.HashSet;
import java.util.Set;

public class Q202copy {  // very special problem, not very useful; not sure about time complexity
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        do{
            set.add(n);
            if(n==1){
                return true;
            }
            int newNum =0;
            while(n>0){
                newNum += Math.pow(n%10,2);
                n/=10;
            }
            n=newNum;
        }
        while(!set.contains(n));
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Q202copy().isHappy(19));
    }
}
