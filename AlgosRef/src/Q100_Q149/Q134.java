package Q100_Q149;

public class Q134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {  // N, 这个题我居然从N^2->N,不仅能做出，而且还会优化了；　这个题最后发现我的题没有完全解出，还是有一定技巧；注意range sum的应用
        if(gas==null || cost==null || gas.length != cost.length)
            return 0;
        int balance = 0;
        int startPoint = -1;
        int curSum = 0;
        for(int i=0; i<gas.length; i++) {  // this correct solution, uses a range sum concept
            balance += gas[i]-cost[i];
            curSum += gas[i]-cost[i];
            if(curSum<0) {   // if curSum becomes negative, then reset
                curSum = 0;
                startPoint = -1;
            } else if (startPoint == -1) {
                startPoint = i;
            }

            //if(startPoint==-1 && gas[i]>=cost[i])  // 这个题我开始考虑的是就设置一次，看来就象celebrity那样，必须不断设置
//            if(startPoint==-1 && balance >=0)
//                startPoint=i;
//            if(balance<0)
//                startPoint=-1;
        }
        if(balance>=0)  // 最后这个check是有必要的
            return startPoint;
        else
            return -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        System.out.println(new Q134().canCompleteCircuit(gas, cost));
    }
}
