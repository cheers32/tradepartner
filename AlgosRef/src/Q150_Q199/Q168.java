package Q150_Q199;

public class Q168 {
    public String convertToTitle(int n) { // N, good solution, no extra space, simple module problem
        StringBuilder res = new StringBuilder();
        while(n>0) {
            int rem = n%26;
            int div = n/26;
            char c = (char)('A'+rem-1);  // this case is required by the question
            if(rem==0) {
                c = 'Z';  // this is a single adjustment, otherwise cannot get 'z'
                div--;  // this must be --, my first error was set to 0
            }
            res.insert(0, c); // this must be inserting to front; char adding to String Builder is ok
            n = div;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q168().convertToTitle(1));
        System.out.println(new Q168().convertToTitle(26));
        System.out.println(new Q168().convertToTitle(27));
        System.out.println(new Q168().convertToTitle(52));
    }
}
