package Q050_Q099;

import java.util.HashSet;
import java.util.Set;

public class Q079v2 {
    public boolean exist(char[][] board, String word) {  // this no-set approach is very fast; m*n*k (search full word at every cell)
        if(board==null || board[0].length==0 || word == null || word.length() == 0)
            return false;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]==word.charAt(0)) {
                    if(search(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean search(char[][] board, String word, int idx, int i, int j) {  // signature needs to be interface type
        if(idx==word.length())
            return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return false;
        if(board[i][j]==' ')  // char must be a space
            return false;
        if(word.charAt(idx)!=board[i][j])
            return false;
        char temp = board[i][j];
        board[i][j] = ' ';
        if(search(board, word, idx+1, i-1, j)) return true;  // up
        if(search(board, word, idx+1, i, j+1)) return true;  // right
        if(search(board, word, idx+1, i+1, j)) return true;  // down
        if(search(board, word, idx+1, i, j-1)) return true;  // left
        board[i][j] = temp;  // this last step must be done, either remove from set or reassign board value
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {{'a', 'a'}};
        System.out.println(new Q079v2().exist(board, "aaa"));
    }
}
