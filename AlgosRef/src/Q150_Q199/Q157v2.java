package Q150_Q199;

public class Q157v2 {

    int read4(char[] buf){ return 0; }

    public int read(char[] buf, int n) {  // N, this is same style as 158; very structured solution, this is better
        char[] tmp4 = new char[4];
        int res = 0;
        while(res<n) {
            int num = read4(tmp4);
            int i = 0;
            while(res<n && i<num) {
                buf[res] = tmp4[i];
                res++;
                i++;
            }
            if(num<4)
                break;
        }
        return res;
    }
}
