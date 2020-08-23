package Q001_Q049;

import java.util.*;

public class Q017v1 {
    public List<String> letterCombinations(String digits) {  // this is DFS method    k^n
        List<String> res = new ArrayList<>();
        if(digits==null || digits.length()==0)
            return res;
        build(digits, 0, res, "");
        return res;
    }

    void build(String digits, int idx, List<String> res, String current) {
        if(idx >= digits.length()) {
            res.add(current);
            return;
        }
        String letters = "";
        switch (digits.charAt(idx)) {
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
        for(char c : letters.toCharArray()) {
            String newStr = current+c;
            build(digits, idx+1, res, newStr);
        }
    }

    public static void main(String[] args) {
        //System.out.println(new Q001_Q049.Q017v1().letterCombinations("23"));
        System.out.println(new Q017v1().letterCombinations("23"));
    }
}
