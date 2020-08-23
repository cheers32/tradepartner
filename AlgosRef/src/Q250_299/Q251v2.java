package Q250_299;

public class Q251v2 {
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
                j++;
                if(j>data[i].length-1) {  // do advancement on access
                    i++;
                    j=0;
                }
                return res;
            }
            return -1;
        }

        public boolean hasNext() {
            while(i<data.length) {
                if (data[i].length == 0) {  // must include this condition to check empty items
                    i++;
                    continue;
                }
                //return j<data[i].length;  // 这里把j的check也放在了这里，就不用再next里检查了
                return true; // 再次改进, 这里也是不用检查j，原因看上去就是只要有一个合理的item即可，advancement在访问时进行
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
