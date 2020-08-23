package Q200_Q249;

import java.util.ArrayList;
import java.util.List;

public class Q247 {  // N, 这个题的关键就在于针对奇数或偶数单独讨论; 我觉得这题用循环做比递归更合理
    public List<String> findStrobogrammatic(int n) {
        if(n<=0)
            return new ArrayList<>();
        List<String> res = new ArrayList<>();
        if(n%2==1) {
            res.add("0");res.add("1");res.add("8");
        } else {
            res.add(""); // corrected, forgot to add empty string, so that subsequent adding won't continue
        }

        while(n>=2) {
            List<String> newRes = new ArrayList<>();
            for(String s : res) {
                if(n>3)  // corrected, this 0 must be handled; corrected again, this must be n>3, not n>2, must consider odd and even cases!
                    newRes.add("0"+s+"0");
                newRes.add("1"+s+"1");newRes.add("8"+s+"8");newRes.add("6"+s+"9");newRes.add("9"+s+"6");
            }
            res = newRes;
            n-=2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q247().findStrobogrammatic(2));
        System.out.println(new Q247().findStrobogrammatic(3));
    }
}
