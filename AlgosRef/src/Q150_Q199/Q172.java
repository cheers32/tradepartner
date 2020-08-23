package Q150_Q199;

public class Q172 {
    public int trailingZeroes(int n) { // N, this is a special tricky solution, gradually add divided result to the final count
        int res = 0;
        while(n>0) {  // n>=5 also works
            int add = n/5;
            res+= add;
            n = add;
        }
        return res;
    }

    public int trailingZeroesWrong(int n) {
        int res = 0;
        while(n>5) {
            res+=1;
            n-=5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q172().trailingZeroes(5));
        System.out.println(new Q172().trailingZeroes(20));
        System.out.println(new Q172().trailingZeroesWrong(20));
        System.out.println(new Q172().trailingZeroes(40));
        System.out.println(new Q172().trailingZeroesWrong(40));
    }
}
