package Q001_Q049;

import static sun.misc.Version.print;

public class Q031 {
    public void nextPermutation(int[] num) {  // two passes, 2*n
        int idxDesc = num.length-1;
        while(idxDesc>0) {
            if(num[idxDesc]>num[idxDesc-1]) {
                break;
            }
            idxDesc--;
        }
        if(idxDesc==0) {  // special case for last permutation
            reverseSort(num, 0, num.length-1);
        } else {
            int idxSwap = num.length-1;
            int target = num[idxDesc-1];
            while(idxSwap>=idxDesc) {
                if(num[idxSwap]>target) {
                    break;
                }
                idxSwap--;
            }
            swap(num, idxSwap, idxDesc-1);
            reverseSort(num, idxDesc, num.length-1);
            return;
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    void reverseSort(int[] nums, int start, int end) {  // this step was incorrectly wrote, it's just star and end to swap
        if(start>=end)
            return;
        while(start<end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[] {3,2,1};
        //int[] input = new int[] {1,2,3};
        new Q031().nextPermutation(input);
        for (int i : input) {
            System.out.println(i);
        }

    }
}
