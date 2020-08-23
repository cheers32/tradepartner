package Q150_Q199;

public class Q157 {

    int read4(char[] buf){ return 0; }

    public int read(char[] buf, int n) {  // N
        char[] tmp4 = new char[4];
        int res = 0;
        while(res<n) {  // loop until reached result or nothing read; remember this is the first condition
            int num = read4(tmp4);
            if(num==0)  // return result if 0 is read
                return res;
            int i = 0;
            while(res<n && i<num) { // read everything until reach to n; as well as ptr<cnt
                buf[res] = tmp4[i];
                res++;
                i++;
//                if(res==n)  // this condition is moved to the while loop
//                    return res;
            }
        }
        return res;
    }
}
