package Q050_Q099;

public class Q058 {
    public int lengthOfLastWord(String s) {  // N, very easy, two steps
        int count = 0;
        int end = s.length()-1;
        while(end>=0) {
            if(s.charAt(end)!=' ') {
                break;
            }
            end--;
        }
        while(end>=0) {
            if(s.charAt(end)==' ') {
                break;
            }
            count++;
            end--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Q058().lengthOfLastWord("hello world "));
    }
}
