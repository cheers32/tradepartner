package Q150_Q199;

import java.util.List;

public class Q151 {
    public String reverseString(String s) { // passed first time, easy N space N speed solution
        if(s==null)
            return "";
        StringBuilder sb = new StringBuilder();
        String[] sList = s.split(" ");
        for(int i=sList.length-1; i>=0; i--) {
            String str = sList[i].trim();
            if(str.length()>0)  // notice only append non-empty strings
                sb.append(str+" ");
        }
        return sb.toString().trim();
    }
}
