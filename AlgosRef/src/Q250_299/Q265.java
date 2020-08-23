package Q250_299;

public class Q265 {
    public int minCostII(int[][] costs) {  // 我的这个做法非常简洁且达到了ＮＫ时间，就是把找Min的这一步单独拿出，这样省去了很多麻烦，只是每行多走一次而已；无额外空间
        if(costs == null || costs.length==0)
            return 0;
        int m = costs[0].length;
        int[] minInfo;
        for(int i=1; i<costs.length; i++) {
            minInfo = findMin(costs[i-1]);
            for(int j=0; j<m; j++) {
                if(j!=minInfo[2]) {
                    costs[i][j]+=minInfo[0];  //若非同index,就选最小的
                } else {
                    costs[i][j]+=minInfo[1];  // 否则选第二小，这个思路是这个题的关键
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int k=0; k<m; k++) {
            res = Math.min(res, costs[costs.length-1][k]);
        }
        return res;
    }

    int[] findMin(int[] nums) {  // 我的这个数据结构的设计还是不错的, min1, min2, min1Idx, min2Idx
        int min1 = Integer.MAX_VALUE;  // corrected: 这里我改成了max value, 最开始的时候我想假设0和1位的数，但那样还要排序一次，且数组必须大于2
        int min2 = Integer.MAX_VALUE;
        int min1Idx = -1;
        int min2Idx = -1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]<min1) {  // 这个判断也不错
                min2 = min1;
                min1 = nums[i];
                min2Idx = min1Idx;
                min1Idx = i;
            } else if(nums[i]<min2) {
                min2 = nums[i];
                min2Idx = i;
            }
        }
        return new int[]{min1, min2, min1Idx, min2Idx};
    }


    public static void main(String[] args) {
        //int[][] input = new int[][] {{1,5,3},{2,9,4}};
        int[] test = new int[] {11,8,11,10};
        int[][] input = new int[][] {{3,14,12,2,20,16,12,2},{9,6,9,8,2,9,20,18},{20,2,20,4,5,12,11,11},{16,3,7,5,15,2,2,4},{17,3,11,1,9,5,7,11}};
        //printArray(new Q265().findMin(test));
//        printArray(new Q265().findMin(input[0]));
//        printArray(new Q265().findMin(input[1]));
//        printArray(new Q265().findMin(input[2]));
//        printArray(new Q265().findMin(input[3]));
//        printArray(new Q265().findMin(input[4]));
        System.out.println(new Q265().minCostII(input));
    }
}
