package Q250_299;

public class Q258copy {
    public int addDigits(int num) { // len(num), 这个题非常trivial, 主要是要其数学做法
        while(num>9) {  // 这里大于9是题设
            int sum = 0;
            while(num>0) {  // 这里又有一个while，要注意不要搞错
                sum+=num%10;
                num/=10;
            }
            num = sum;  // 最后一个置换
        }
        return num;
    }

    public int addDigits_math(int num) {
        if(num==0)
            return 0;
        if(num%9==0)
            return 9;
        return num%9;  // 注意这里就是一直在用标准数学做法
    }
}
