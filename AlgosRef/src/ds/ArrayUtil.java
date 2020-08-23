package ds;

public class ArrayUtil {
    public static void print2DArray(int[][] array) {
        for(int i=0; i<array.length; i++) {
            for(int j=0; j<array[0].length; j++) {
                System.out.print(array[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void printArray(int[] array) {
        for(int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
