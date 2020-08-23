package Q050_Q099;

public class Q067 {
    public String addBinary(String a, String b) {  // standard solution, very intuitive, passed at first time
        int idxA = a.length()-1;
        int idxB = b.length()-1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(idxA>=0 || idxB>=0) {
            int vA = idxA>=0 ? a.charAt(idxA)-'0' : 0;  // must use - '0' to parse char
            int vB = idxB>=0 ? b.charAt(idxB)-'0' : 0;
            int sum = vA + vB + carry;
            int rem = sum%2;
            carry = sum/2;
            res.insert(0, rem);  // directly insert int is ok
            idxA--;
            idxB--;
        }
        if(carry == 1) {
            res.insert(0, 1);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q067().addBinary("11","1"));
        System.out.println(new Q067().addBinary("11","0"));
        System.out.println(new Q067().addBinary("101","1"));
    }
}
