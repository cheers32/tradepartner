package Q001_Q049;

public class Q042 {
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int leftH = 0;
        int[] leftWater = new int[height.length];
        for(int i=0; i<height.length; i++) {
            leftWater[i] = Math.max(0, leftH-height[i]);
            leftH = Math.max(leftH, height[i]);
        }
        int rightH = 0;
        int sum = 0;
        for(int i=height.length-1; i>=0; i--) {
            int rightWater = Math.max(0, rightH-height[i]);
            rightH = Math.max(rightH, height[i]);
            int resWater = Math.min(leftWater[i], rightWater);
            sum += resWater;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] input = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Q042().trap(input));
    }
}
