package Q150_Q199;

import java.util.HashMap;
import java.util.Map;

public class Q170 {
    public static class TwoSum {  // N space, 1 time to find, standard solution, just one point as trick
        Map<Integer, Integer> map;  // num, cnt

        public TwoSum() {
            map = new HashMap<>();
        }

        public void add(int number) {
            if(map.containsKey(number)) {
                map.put(number, map.get(number)+1);
            } else {
                map.put(number, 1);
            }
        }

        public boolean find(int value) {
            for(int n : map.keySet()) {
                if(map.containsKey(value-n)) {
                    int cnt = map.get(value-n);
                    if(n == value-n) // so must discount cnt by one to solve all cases
                        cnt--;
                    //if(cnt>0 || n==value-n && cnt>1)  // this is not right, because if 0 is used, there's only one 0 needed, but required to find a pair, so should be false
                    // similar as just one 4, and want to find target 8, there's no pair, so need to return false
                    if(cnt>0)
                        return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        TwoSum algo = new TwoSum();
        algo.add(0);
        System.out.println(algo.find(0));
        algo.add(4);
        System.out.println(algo.find(8));
        algo.add(4);
        System.out.println(algo.find(8));
    }
}
