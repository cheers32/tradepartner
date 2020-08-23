package Q001_Q049;

import java.util.ArrayList;
import java.util.List;

public class Q017v2 {
    public List<String> letterCombinations(String digits) { // this is backtracking, standard recursion    k^n
        if(digits==null || digits.length()==0)
            return new ArrayList<>();
        return build(digits);
    }

    List<String> build(String digits) {
        if(digits.length() == 0) {
            List<String> res = new ArrayList<>();
            res.add("");  // use this empty string as default first value
            return res;
        }
        String letters = "";
        Character first = digits.charAt(0);
        List<String> rest = build(digits.substring(1));
        switch (first) {
            case '2': letters = "abc"; break;
            case '3': letters = "def"; break;
            case '4': letters = "ghi"; break;
            case '5': letters = "jkl"; break;
            case '6': letters = "mno"; break;
            case '7': letters = "pqrs"; break;
            case '8': letters = "tuv"; break;
            case '9': letters = "wxyz"; break;
            // default is not valid char
        }
        List<String> res = new ArrayList<>();  // add a new res list
        for(char c : letters.toCharArray()) {
            for(String e : rest) {
                res.add(c+e);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q017v1().letterCombinations("23"));
    }
}
