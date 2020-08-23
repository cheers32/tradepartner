package Q200_Q249;

import java.util.*;

public class Q218copy2 {  // NLogN, 这个方法相当的巧妙，使用了一个Merge sort的方法，对于任意两组坐标，各自维护一个最高点，即可在merge过后获得一个按x排序好的新的坐标集合
    public List<List<Integer>> getSkyline(int[][] buildings) {
        return dfs(buildings, 0, buildings.length-1);
    }

    List<List<Integer>> dfs(int[][] arr, int l,int r) {
        List<List<Integer>> res = new ArrayList<>();
        if(l>r) {  // base case
            return res;
        }

        if(l==r) {  // only at single point to re-format
            int[] a = arr[l];
            res.add(Arrays.asList(a[0], a[2]));
            res.add(Arrays.asList(a[1], 0));  // end as 0

            return res;
        }

        int m = l + (r-l)/2;

        List<List<Integer>> a1 = dfs(arr, l, m);
        List<List<Integer>> a2 = dfs(arr, m+1, r);

        int c1 = 0;  // array 1 idx
        int c2 = 0;
        int h1 = 0;  // height so far for array 1
        int h2 = 0;

        while(c1<a1.size() && c2<a2.size()) {
            int x1 = a1.get(c1).get(0);
            int x2 = a2.get(c2).get(0);
            if(x1<x2) {
                h1 = a1.get(c1).get(1);  // selected new height from array 1 because it has a better x
                c1++;
            }else if(x1>x2) {
                h2 = a2.get(c2).get(1);
                c2++;
            }else{
                h1 = a1.get(c1).get(1);  // select both if overlapping
                h2 = a2.get(c2).get(1);
                c1++;
                c2++;
            }

            int x = Math.min(x1, x2);
            int h = Math.max(h1, h2);  // get the max from the two

            if(res.isEmpty() || res.get(res.size()-1).get(1)!=h) {  // check with prev max
                res.add(Arrays.asList(x, h));
            }
        }

        while(c1<a1.size()) {
            res.add(a1.get(c1++));  // add every remaining items, also means res and a1, a2 are same format
        }

        while(c2<a2.size()) {
            res.add(a2.get(c2++));
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] { {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} };
        List<List<Integer>> res = new Q218copy2().getSkyline(input);
        System.out.println(res);
    }
}
