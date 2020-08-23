package Q001_Q049;

public class Q032 {
    public int longestValidParentheses(String s) {  // 2*n, two passes, easy problem
        int leftCnt = 0;
        int rightCnt = 0;
        int res = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') {
                leftCnt++;
            } else if(s.charAt(i)==')') {
                rightCnt++;
            }
            if(leftCnt==rightCnt)  // update only when matching
                res = Math.max(leftCnt*2, res);
            else if(leftCnt<rightCnt) {  // reset counting case, e.g. ())
                leftCnt=0;
                rightCnt=0;
            }
        }
        leftCnt = 0;
        rightCnt = 0;
        // right to left to count again
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i)=='(') {
                leftCnt++;
            } else if(s.charAt(i)==')') {
                rightCnt++;
            }
            if(leftCnt==rightCnt)  // update only when matching
                res = Math.max(leftCnt*2, res);
            else if(leftCnt>rightCnt) {  // reset counting case, e.g. ()), this is left>right
                leftCnt=0;
                rightCnt=0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q032().longestValidParentheses("(()"));
    }
}
