package Q100_Q149;

import java.util.HashMap;
import java.util.Map;

public class Q128 {
    public int longestConsecutive(int[] nums) {  // N, space 2N, my approach is very good, the only thing missing was the duplicate check; this case should be evaluated
        if(nums == null)
            return 0;
        Map<Integer, Integer> leftMap = new HashMap<>();  // idx, left boundary
        Map<Integer, Integer> rightMap = new HashMap<>();  // idx, right boundary
        int max = 0;

        for(int i=0; i<nums.length; i++) {  // 这个题最主要的思路就在越把当前右端的左边界更新，左端的右边界更新，若非边界理论上不用更新
            int num = nums[i];
            if(leftMap.containsKey(num)) // 这个重复出现的去掉就没有问题了；因为我是每次更新两端，再出现时就已经不是两端的值了
                continue;
            int left = num-1;
            int right = num+1;
            leftMap.put(num, leftMap.getOrDefault(left, num));
            rightMap.put(num, rightMap.getOrDefault(right, num));
            int leftMostCurSeg = leftMap.get(num);
            int rightMostCurSeg = rightMap.get(num);
            //leftMap.put(leftMostCurSeg, leftMap.get(num));  // 最开始我是更新左右的值，而实际上是左右端的值才对
            leftMap.put(rightMostCurSeg, leftMap.get(num));  // 只有这两行需要
            rightMap.put(leftMostCurSeg, rightMap.get(num));
            //rightMap.put(rightMostCurSeg, rightMap.get(num));
            int len = rightMap.get(num)-leftMap.get(num)+1;  // 每次求最大
            max = Math.max(max, len);

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
        //int[] input = new int[] {0,1,-1};
        //int[]  input = new int[] {0,3,7,2,5,8,4,6,0,1};
        int[] input = new int[] {-1,9,-3,-6,7,-8,-6,2,9,2,3,-2,4,-1,0,6,1,-9,6,8,6,5,2};
        System.out.println(new Q128().longestConsecutive(input));
    }
}
