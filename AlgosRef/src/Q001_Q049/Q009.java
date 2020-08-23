package Q001_Q049;

public class Q009 {
    public boolean isPalindrome(int x) {  // n
        if (x<0) return false;
        String num = String.valueOf(x);
        int s = 0;
        int e = num.length()-1;
        while(s<e) {
            if(num.charAt(s)!=num.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q009().isPalindrome(5));
        System.out.println(new Q009().isPalindrome(51));
        System.out.println(new Q009().isPalindrome(0));
        System.out.println(new Q009().isPalindrome(-7));
        System.out.println(new Q009().isPalindrome(332233));
    }
}
