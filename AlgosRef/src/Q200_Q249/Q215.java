package Q200_Q249;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q215 {
    public int findKthLargest(int[] nums, int k) { // nlogK is good enough, with k space
        final PriorityQueue<Integer> pq = new PriorityQueue<>();  // by default this is a min heap, the big numbers are all at bottom, top is kth biggest (smallest of all), below are all qualified big numbers
        //final PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // this will make it a max heap, top is kth smallest, all small numbers are at bottom

        // these are for max heap:
        Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>(){ // Method 1
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });
        Queue<Integer> q2 = new PriorityQueue<>((a,b)->b-a); //Method 2
        //Queue<Integer> q3 = new PriorityQueue<>(Collections.reverseOrder());  //Method 3
        for(int val : nums) {
            pq.offer(val);  // pq要先进后出
            if(pq.size() > k) { // should put k in here, rather than putting at init
                pq.poll();  // the smallest is out
            }
        }
        return pq.peek();
    }

    public int findKthLargest_Wrong(int[] nums, int k) {
        if(nums==null || k<=0)
            return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int n : nums) {
            if(pq.isEmpty() || n>pq.peek()) {
                pq.offer(n);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[] {3,2,4,5,2};
        System.out.println(new Q215().findKthLargest(input, 1));
        //System.out.println(new Q215().findKthLargest_Wrong(input, 1));
    }
}

