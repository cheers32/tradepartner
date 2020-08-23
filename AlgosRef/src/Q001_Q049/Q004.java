package Q001_Q049;

public class Q004 {  //　log((m+n)/2) 这个题非常重要，这次做出来非常关键，这个binary search的概念必须牢记于心
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { // assume both input are valid
        int len = nums1.length + nums2.length;
        if(len%2==1) {
            double res = getKthSmallest(nums1, 0, nums2, 0, len / 2+1);
            return res;
        }
        else {
            double left = getKthSmallest(nums1, 0, nums2, 0, len/2);
            double right = getKthSmallest(nums1, 0, nums2, 0, len/2+1);
            return (left+right)/2;
        }
    }

    public double getKthSmallest(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if(start1>=nums1.length)
            return nums2[start2+k-1];
        if(start2>=nums2.length)
            return nums1[start1+k-1]; // return the other's kth if one is exhausted, this can apply as empty array case
        if(k==1)
            return Math.min(nums1[start1], nums2[start2]);
        int mIdx1 = start1+k/2-1;
        int mIdx2 = start2+k/2-1;
        int mVal1 = mIdx1<nums1.length ? nums1[mIdx1] : Integer.MAX_VALUE;
        int mVal2 = mIdx2<nums2.length ? nums2[mIdx2] : Integer.MAX_VALUE;

        if(mVal1<mVal2) {
            return getKthSmallest(nums1, mIdx1+1, nums2, start2, k-k/2);
        } else {
            return getKthSmallest(nums1, start1, nums2, mIdx2+1, k-k/2);
        }
    }

    public static void main(String[] args) {
        int[] a1 = new int[] {1,5,7,12,19,22};
        int[] a2 = new int[] {33,34,36};
        int[] a3 = new int[] {3,36};
        //System.out.println(new Q004().getKthSmallest(a1, 0, a2, 0, 4));
//        System.out.println(new Q004().getKthSmallest(a1, 0, a2, 0, 1));
//        System.out.println(new Q004().getKthSmallest(a1, 0, a2, 0, 2));
//        System.out.println(new Q004().getKthSmallest(a1, 0, a2, 0, 3));
        System.out.println(new Q004().findMedianSortedArrays(a1, a2));
        System.out.println(new Q004().findMedianSortedArrays(a1, a3));

    }
}
