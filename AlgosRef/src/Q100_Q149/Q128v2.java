package Q100_Q149;

import java.util.HashMap;
import java.util.Map;

public class Q128v2 {  // 这个变形写法,只需要一个map
    public int longestConsecutive(int[] nums) { // N, space N
        if(nums == null)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();  // idx, count in this segment
        int max = 0;

        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(num)) // 这个重复出现的去掉就没有问题了；因为我是每次更新两端，再出现时就已经不是两端的值了
                continue;
            int left = num-1;
            int right = num+1;
            int leftCount = map.getOrDefault(left, 0);
            int rightCount = map.getOrDefault(right, 0);
            int len = leftCount+rightCount+1;
            max = Math.max(max, len);
            map.put(num, len);  // this step is needed, otherwise it's not correct, because duplicate won't be recognized
            map.put(num-leftCount, len);   // this is num +-, don't put left/right
            map.put(num+rightCount, len);
        }
        return max;
    }

//    public int longestConsecutive(int[] nums) {
//        if(nums == null)
//            return 0;
//        Map<Integer, Integer> idxLeft = new HashMap<>();  // idx, left boundary
//        Map<Integer, Integer> idxRight = new HashMap<>();  // idx, right boundary
//        int max = 0;
//
//        for(int i=0; i<nums.length; i++) {
//            int num = nums[i];
//            int left = num-1;
//            int right = num+1;
//            if(!idxLeft.containsKey(left)) {
//                idxLeft.put(num, num);
//            } else {
//                int newLeft = idxLeft.get(left);
//                idxLeft.put(num, newLeft);
//                idxRight.put(num, idxLeft.get(right));
//            }
//            if(!idxRight.containsKey(right)) {
//                idxRight.put(num, num);
//            } else {
//                int newRight = idxRight.get(right);
//                idxRight.put(num, newRight);
//                if(idxRight.containsKey(left))
//                    idxRight.put(left, newRight);
//            }
//
//            int len = idxRight.get(num)-idxLeft.get(num)+1;
//            max = Math.max(max, len);
//
//        }
//        return max;
//    }

    public static void main(String[] args) {
        //int[] input = new int[] {1,2,4,3};
        //int[] input = new int[] {7,6,8,9};
        //int[] input = new int[] {0,1,-1};
        //int[]  input = new int[] {0,3,7,2,5,8,4,6,0,1};
        //int[] input = new int[] {-1,9,-3,-6,7,-8,-6,2,9,2,3,-2,4,-1,0,6,1,-9,6,8,6,5,2};
        int[] input = new int[] {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};

        System.out.println(new Q128v2().longestConsecutive(input));
    }
}
