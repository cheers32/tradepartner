package Q150_Q199;

public class Q161v2copy {

    public boolean isOneEditDistance(String s, String t) {  // this online solution is a N^2 solution, not very good; and only applies to this problem
        // this solution gets fastest time
        // this can add a quick check of length>2, maybe not necessary
        // this solution is not N^2, it's min of the two length; longlong's solution is similar by using index

        for(int i=0; i<Math.min(s.length(), t.length()); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(s.length()==t.length()) {
                    return s.substring(i+1).equals(t.substring(i+1));
                }
                else if(s.length()<t.length()) {  // this is like the longer string advance one to skip the diff
                    return s.substring(i).equals(t.substring(i+1));
                }
                else {
                    return t.substring(i).equals(s.substring(i+1));
                }
            }
        }
        return Math.abs(s.length()-t.length())==1;
    }
    public static void main(String[] args) {
        System.out.println(new Q161v2copy().isOneEditDistance("ac","acb"));
        //System.out.println(new Q161().isOneEditDistance("ac","adb"));
        //System.out.println(new Q161().isOneEditDistance("a",""));
        //System.out.println(new Q161().isOneEditDistance("a","aa"));
    }
}
