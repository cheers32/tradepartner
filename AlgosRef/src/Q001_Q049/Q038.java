package Q001_Q049;

public class Q038 {
    public String countAndSay(int n) {  // what is time complexity? maybe N
        if(n<=1)
            return "1";
        String s = countAndSay(n-1);
        int cnt = 1;
        char cur = s.charAt(0);
        StringBuilder res = new StringBuilder();
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i)==cur) {
                cnt++;
            }
            else {
                res.append(String.valueOf(cnt)+cur);
                cur = s.charAt(i);
                cnt = 1;
            }
        }
        res.append(String.valueOf(cnt)+cur);  // naturally can remind this last append
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q038().countAndSay(3));
    }
}
