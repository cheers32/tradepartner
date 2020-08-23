package Q200_Q249;

public class Q204 {
    public int countPrimes(int n) {  // N
        boolean[] arr = new boolean[n+1];
        int count = 0;
        for(int i=2; i<n; i++) {  // problem requires <, not less than; must start from 2, because 1 is not prime
            if(!arr[i]) {
                count++;
//                if(i==1)
//                    continue;
                int multiple = 2;
                while(multiple*i<=n) { // use product to compare is better than using multiple to iterate
                    arr[multiple*i]=true;
                    multiple++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Q204().countPrimes(2));
    }
}
