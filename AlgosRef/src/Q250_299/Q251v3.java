package Q250_299;

public class Q251v3 {  // N， 最后一个改进版本,把所有check都放入hasnext
    static class Vector2D {
        int i = 0;
        int j = 0;
        int[][] data;

        public Vector2D(int[][] v) {  // N， 这次我的改进在于把hasnext和next合到了一起，这样就不会浪费时间了
            data = v;
        }

        public int next() {
            if(hasNext()) {
                int res = data[i][j];
                j++;  // 直接作简单advancement即可返回结果
                return res;
            }
            return -1;
        }

        public boolean hasNext() {
            while(i<data.length) {
                if (j>data[i].length-1) {  // 这个条件很重要，这样len==0的case就被包括了
                    i++;
                    j=0;
                    continue;
                }
                //return j<data[i].length;  // 这里把j的check也放在了这里，就不用再next里检查了
                return true;  // j已经检查过了，所以直接返回true即可
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Vector2D vector2D = new Vector2D(new int[][] {{1,2},{3},{4}});
        //Vector2D vector2D = new Vector2D(new int[][] {{},{3}});
        System.out.println(vector2D.next());
        System.out.println(vector2D.next());
        //System.out.println(vector2D.hasNext());
        //System.out.println(vector2D.hasNext());
        System.out.println(vector2D.next());
        System.out.println(vector2D.hasNext());
        System.out.println(vector2D.next());
        //System.out.println(vector2D.next());
        System.out.println(vector2D.hasNext());
        //System.out.println(vector2D.next());
        //System.out.println(vector2D.next());
        //System.out.println(vector2D.next());
    }
}
