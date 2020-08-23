package Q100_Q149;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q148 {  // this version is to practice quick sort and merge sort, and merge in place, NLogN
    public void quickSort(List<Integer> list) {
        if(list == null)
            return;
        quickSort(list, 0, list.size()-1);
    }

    public void quickSort(List<Integer> list, int start, int end) {
        if(start>end)
            return;
        int pivot = list.get(end);
        int smallIdx = start;
        for(int i=start; i<end; i++) {
            if(list.get(i)<pivot) {
                swap(list, i, smallIdx);
                smallIdx++;
            }
        }
        swap(list, smallIdx, end);  // important step, must remember
        quickSort(list, start, smallIdx-1);  // this is -1 and +1, without including pivot
        quickSort(list, smallIdx+1, end);
    }

    void swap(List<Integer> list, int i, int j) {
        int tmp = list.get(j);
        list.set(j, list.get(i));
        list.set(i, tmp);
    }

    public void mergeSort(List<Integer> list) {
        if(list==null)
            return;
        mergeSort(list, 0, list.size()-1);  // this last index is used, so need to be len-1
    }

    public void mergeSort(List<Integer> list, int start, int end) {
        if(start>=end)  // this >= is used because the mid value is needed
            return;
        int midIdx = (start+end)/2;
        mergeSort(list, start, midIdx);
        mergeSort(list, midIdx+1, end);
        //merge(list, start, midIdx, midIdx+1, end);
        mergeInPlace(list, start, midIdx, midIdx+1, end);
    }

    void merge(List<Integer> list, int s1, int e1, int s2, int e2) {
        int idx = s1;  // this must starts with s1
        List<Integer> tmp = new ArrayList<>();
        while(s1<=e1 || s2<=e2) {  // notice this is <=
            int v1 = s1<=e1?list.get(s1):Integer.MAX_VALUE;
            int v2 = s2<=e2?list.get(s2):Integer.MAX_VALUE;
            if(v1<v2) {
                tmp.add(v1);
                s1++;
            } else {
                tmp.add(v2);
                s2++;
            }
            //idx++;
        }
        for(int n : tmp)
            list.set(idx++, n);
    }

    void mergeInPlace(List<Integer> list, int s1, int e1, int s2, int e2) {  // not fully tested, the idea is like this
        // for in place, needs to start from arr2 last idx, then find smallest larger value from arr1, then switch last from arr1 to last of arr2, insert last of arr2 to new place, all others move 1 space; N^2 time
        for(int i=e2; i>=s2; i--) {
            int lastFromArr2 = list.get(i);
            int j=s1;
            for(; j<=e1; j++) {
                if(list.get(j)>lastFromArr2)
                    break;
            }
            if(j>e1)  // this step is important in case no greater value is found from array 1
                continue;
            list.set(i, list.get(e1));
            for(int k=e1; k>j; k--) {
                list.set(k, list.get(k-1));
            }
            list.set(j, lastFromArr2);
        }
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(4,2,1,3,6,7,5);
//        new Q148().quickSort(input);
//        System.out.println(input);

        //input = Arrays.asList(2,4,1,3,6,7,5);
        new Q148().mergeSort(input);
        System.out.println(input);

        input = Arrays.asList(1,5,9,10,15,20,2,3,8,13);
        //new Q148().mergeInPlace(input, 0, 5, 6, 9);
    }
}
