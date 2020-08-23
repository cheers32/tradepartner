package Q001_Q049;

public class Q014 {
    public String longestCommonPrefix(String[] strs) {  // n*k (k is min len of all strings)
        if(strs == null || strs.length == 0) {
            return "";
        }
        String first = strs[0];
        for(int i=0; i<first.length(); i++) {
            for(int j=1; j<strs.length; j++) {
                if(i>=strs[j].length() || first.charAt(i)!=strs[j].charAt(i)) {
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }

    public static void main(String[] args) {
//        String[] input = new String[] {"flower","flow","flight"};
//        System.out.println(new Q001_Q049.Q014().longestCommonPrefix(input));
//        input = new String[] {"dog","racecar","car"};
//        System.out.println(new Q001_Q049.Q014().longestCommonPrefix(input));
        String[] input = new String[] {"aa", "a"};
        System.out.println(new Q014().longestCommonPrefix(input));
    }
}
