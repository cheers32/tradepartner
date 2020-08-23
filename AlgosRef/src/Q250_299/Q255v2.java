package Q250_299;

public class Q255v2 {  // 这个改进方法是加入max, min, 但速度还是不是很快，这个速度是N^2, 因为最后会拆分为N层，每层N个
    public boolean verifyPreorder(int[] preorder) {
        if(preorder==null)
            return false;
        return verify(preorder, 0, preorder.length-1, Integer.MIN_VALUE, Integer.MAX_VALUE);  // just use exact inclusion match for start and end
    }

    boolean verify(int[] data, int start, int end, int min, int max) {
        if(start>end)
            return true;
        int val = data[start];
        int idx = start+1;
        while(idx<=end) {
            if(data[idx]>max || data[idx]<min)
                return false;
            if(data[idx]>val)
                break;
            idx++; // corrected: don't forget idx++ during while loop
        }
        boolean left = verify(data, start+1, idx-1, min, val);
        boolean right = verify(data, idx, end, val, max);
        return left && right;
    }

    public static void main(String[] args) {
        System.out.println(new Q255().verifyPreorder(new int[] {5,2,1,3,6}));
        System.out.println(new Q255v2().verifyPreorder(new int[] {5,2,6,1,3}));
    }
}
