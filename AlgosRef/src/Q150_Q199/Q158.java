package Q150_Q199;

public class Q158 {

    int read4(char[] buf){ return 0; }

    int buffPtr = 0;
    int buffCnt = 0;
    char[] tmp4 = new char[4];

    public int read(char[] buf, int n) {
        int res = 0;
        while(res<n) {
            if(buffPtr==0) {  // EXTRA; this was num in last question; re-read if i is 0
                buffCnt = read4(tmp4);
            } // this time, no chanllege to 0 read
            while(res<n && buffPtr<buffCnt)  // buffPtr is the i, becomes global; buffCnt is the num, becomes global too
            {
                buf[res] = tmp4[buffPtr];
                res++;
                buffPtr++;
            }
            if(buffPtr==buffCnt)  // EXTRA; extra step to reset i to 0 if used up
                buffPtr=0;
            if(buffCnt<4)  // check whether the read was last read
                break;
        }
        return res;
    }
}
