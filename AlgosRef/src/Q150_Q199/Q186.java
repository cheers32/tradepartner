package Q150_Q199;

public class Q186 {
    public void reverseWords(char[] s) { // N, in-place, easy solution
        if(s==null)
            return;
        reverse(s, 0, s.length-1);
        int start = 0;
        for(int i=0; i<s.length; i++) {
            if(s[i]==' ') {     // cannot add a condition here to solve the end problem, must add to the end
                reverse(s, start, i-1);
                start = i+1;
            }
        }
        reverse(s, start, s.length-1);  // just one thing to notice: last word must also be reversed; need to run a test to verify, must run to the end to find out
    }

    void reverse(char[] s, int start, int end) {
        while(start<end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] input = "the sky is blue".toCharArray();
        new Q186().reverseWords(input);
        System.out.println(input);
    }
}
