package Q200_Q249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q249 {
    public List<List<String>> groupStrings(String[] strings) { // len(s)*N, not too difficult, but the key construction must be correctly tested
        if(strings == null)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings) {
            String key = getKey(s);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> v : map.values())  // here must do this, cannot cast directly from Collection<List<String>>
            res.add(v);
        return res;
    }

    String getKey(String s) {
        StringBuilder sb = new StringBuilder();
        int offset = s.charAt(0)-'a';  // this offset will be used for every char to form a key
        for(char c : s.toCharArray()) {
            if(c-offset<'a') {   // corrected: this az and ba is supposed to be in same group, so it needs this adjustment, must handle this case correct, through examples
                sb.append(c-offset+26);
            } else {
                sb.append(c - offset);  // corrected: i tried to add offset here, but that's wrong, e.g. c-'a'
            }
            //sb.append(c-'a');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q249().groupStrings(new String[] {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
    }
}
