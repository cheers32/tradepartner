package Q050_Q099;

public class Q066 {
    public int[] plusOne(int[] digits) { // N, easy solution, standard
        if(digits == null || digits.length == 0)
            return new int[] {0};
        int carry = 0;
        for(int i=digits.length-1; i>=0; i--) {
            int sum = digits[i]+carry;
            if(i==digits.length-1)  // only add 1 at the last digit, don't add to all digits
                sum+=1;
            digits[i] = sum%10;
            carry = sum/10;
        }
        if(carry == 1) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2};
        int[] res = new Q066().plusOne(input);
        System.out.println(res);
    }
}
