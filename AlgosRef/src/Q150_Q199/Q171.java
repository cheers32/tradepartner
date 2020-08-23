package Q150_Q199;

public class Q171 {
    public int titleToNumber(String s) { // N, trivial solution
        if(s==null)
            return 0;
        int res = 0;
        for(char c : s.toCharArray()) {
            int value = c-'A'+1;
            res *= 26;
            res += value;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q171().titleToNumber("AA"));
        System.out.println(new Q171().titleToNumber("Z"));
    }
}
