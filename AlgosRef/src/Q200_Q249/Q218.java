package Q200_Q249;

import java.util.*;

public class Q218 {
    public List<List<Integer>> getSkyline(int[][] buildings) { // 这个题我原来的思路是做一个Map，放每个idx上对应的最大高度，但这个map的创建需要走全部building,很慢
        // 现在更好的方法是，只针对高度点建一个list,里面分别放start和end的高度
        // 然后按照x坐标排序后，针对每一个x评估最大高度，这里使用一个pq,在开始时放入，结束时拿出
        // 这样后面的做法和笨办法相同，即维护一个之前最大高度，然后看是否有变化；注意ｐｑ的使用需要加一个0
        if(buildings==null)
            return new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b : buildings) {
            height.add(new int[]{b[0],b[2]});  // start is positive, end is negative
            height.add(new int[]{b[1],-b[2]});
        }
        Collections.sort(height, (a,b)->a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]); // same x, then higher y first
        List<List<Integer>> res = new ArrayList<>();
        Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        pq.offer(0);
        int prevMax = 0;
        for(int[] h : height) {
            if(h[1]>0) {
                pq.offer(h[1]);
            } else {
                pq.remove(-h[1]);  // this is a n speed operation
            }
            int curMax = pq.peek();
            if(curMax!=prevMax) {
                List<Integer> item = new ArrayList<>();
                item.add(h[0]); item.add(curMax);
                res.add(item);
            }
            prevMax = curMax;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] { {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} };
        List<List<Integer>> res = new Q218().getSkyline(input);
        System.out.println(res);
    }
}
