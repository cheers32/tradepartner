package Q050_Q099;

public class Q088 {  // very easy solution, M+N
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m+n-1;
        while(m>=1 || n>=1) {  // this can also be looping idx to 0
            int v1 = m>=1? nums1[m-1] : Integer.MIN_VALUE;
            int v2 = n>=1? nums2[n-1] : Integer.MIN_VALUE;
            if(v1>=v2) {
                nums1[idx] = v1;
                m--;
            } else {
                nums1[idx] = v2;
                n--;
            }
            idx--;
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[] {1,2,3,0,0,0};
        int[] num2 = new int[] {2,5,6};
        new Q088().merge(num1, 3, num2, 3);
        System.out.println(num1);
    }
}
