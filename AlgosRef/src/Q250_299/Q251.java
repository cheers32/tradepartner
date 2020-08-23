package Q250_299;

public class Q251 {
    static class Vector2D {
        int i = 0;
        int j = 0;
        int[][] data;

        public Vector2D(int[][] v) {//终于通过了，这题做的不好，　时间好像也不是很快
            data = v;
        }

        public int next() {  // 这里我的问题在于，hasnext和Next有重复逻辑
            while(i<data.length) {
                if(data[i].length==0) {  // must include this condition to check empty items
                    i++;
                    continue;
                }
                if(j<data[i].length) {
                    int res = data[i][j];
                    j++;
                    if(j>data[i].length-1) {
                        i++;
                        j=0; // corrected: forgot to reset j!!, shouldn't be
                    }
                    return res;
                }
            }
            return -1;
        }

        public boolean hasNext() {  // 这里的要点是不能破坏当前的ｉ，并且不用check j，因为j已经先行advance了，只要有valid i即可
            int tempI = i;
            while(tempI<data.length) {
                if (data[tempI].length == 0) {  // must include this condition to check empty items
                    tempI++;
                    continue;
                }
                //return tempI<data.length;  // 这里之前写到了外面，结果造成有valid i时的死循环，要注意
                return true;
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
