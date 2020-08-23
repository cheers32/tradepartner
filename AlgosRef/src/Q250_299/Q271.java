package Q250_299;

import java.util.ArrayList;
import java.util.List;

public class Q271 {
    public static class Codec {  // 这个题熟悉思路后就不难，时间为Ｎ，我开始没有想到用数字的方式，要记住这种压缩方法

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            if(strs==null)
                return "";
            StringBuilder sb = new StringBuilder();
            for(String s : strs) {
                sb.append(s.length()+"|"+s);
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            if(s==null || s.length()==0)
                return new ArrayList<>();
            int start = 0;
            List<String> res = new ArrayList<>();
            for(int i=0; i<s.length(); i++) {
                //i = s.indexOf('|', start);  // 这个优化对我来说没有用，因为不影响时间
                if(s.charAt(i)=='|') {
                    int len = Integer.valueOf(s.substring(start, i));
                    res.add(s.substring(i+1, i+len+1));  // corrected: this is actually i+1+len, meaning after the |
                    i+=len;  // += len before auto inc by 1
                    start=i+1;  // corrected: forgot to advance start; because no auto inc for start, so it goes there manually
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple"); list.add("orange");
        String s = new Codec().encode(list);
        System.out.println(new Codec().decode(s));
    }
}
