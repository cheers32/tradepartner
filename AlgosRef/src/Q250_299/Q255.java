package Q250_299;

public class Q255 {  // 这个题我觉得就是去掉第一个，然后后面找到第一个比自己大的数，然后分两半递归
    public boolean verifyPreorder(int[] preorder) {  // 一次性通过了，但是速度好像不是很快，我这个速度肯定不是N,因为有重复计算
        if(preorder==null)
            return false;
        return verify(preorder, 0, preorder.length-1);  // just use exact inclusion match for start and end
    }

    boolean verify(int[] data, int start, int end) {
        if(start>end)
            return true;
        int val = data[start];
        int idx = start+1;
        while(idx<=end) {
            if(data[idx]>val)
                break;
            idx++; // corrected: don't forget idx++ during while loop
        }
        int rightIdx = idx;
        while(rightIdx<=end) {   // corrected: must add this right side condition before recursive call
            if(data[rightIdx]<val)
                return false;
            rightIdx++;
        }
        boolean left = verify(data, start+1, idx-1);
        boolean right = verify(data, idx, end);
        return left && right;
    }

    public static void main(String[] args) {
        //System.out.println(new Q255().verifyPreorder(new int[] {5,2,1,3,6}));
        System.out.println(new Q255().verifyPreorder(new int[] {5,2,6,1,3}));
    }
}
