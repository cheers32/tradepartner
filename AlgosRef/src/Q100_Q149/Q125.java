package Q100_Q149;

public class Q125 {
    public boolean isPalindrom(String s) {  // N, easy solution; note the Character methods: isDigit, isLetter, toLowerCase
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            char start = s.charAt(i);
            char end = s.charAt(j);
            if(!Character.isLetter(start) && !Character.isDigit(start))
                i++;
            else if(!Character.isLetter(end) && !Character.isDigit(end))
                j--;
            else {
                if(Character.toLowerCase(start)!=Character.toLowerCase(end))
                    return false;
                i++;
                j--;
            }
        }
        return true;
    }
}
