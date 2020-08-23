package Q001_Q049;

import java.util.ArrayList;
import java.util.List;

public class Q022 {
    public List<String> generateParenthesis(int n) { // 2^n
        List<String> res = new ArrayList<>();
        build(res, n, n, "");
        return res;
    }

    void build(List<String> res, int leftRem, int rightRem, String cur) {
        if(leftRem==0 && rightRem==0) {
            res.add(cur);
            return;
        }
        if(leftRem > rightRem)
            return;
        if(leftRem>0) {
            build(res, leftRem-1, rightRem, cur+"(");
        }
        if(rightRem>0) {
            build(res, leftRem, rightRem-1, cur+")");
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q022().generateParenthesis(2));
    }
}
