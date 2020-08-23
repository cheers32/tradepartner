package Q050_Q099;

import java.util.HashSet;
import java.util.Set;

public class Q079 {
    public boolean exist(char[][] board, String word) {
        if(board==null || board[0].length==0 || word == null || word.length() == 0)
            return false;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]==word.charAt(0)) {
                    Set<String> visited = new HashSet<>();
                    if(search(board, word, 0, i, j, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean search(char[][] board, String word, int idx, int i, int j, Set<String> visited) {  // signature needs to be interface type
        if(idx==word.length())
            return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return false;
        if(visited.contains(i+"_"+j))  // this visited can be replaced by marking the board to "", then reassign it back
            return false;
        if(word.charAt(idx)!=board[i][j])
            return false;
        visited.add(i+"_"+j);
        if(search(board, word, idx+1, i-1, j, visited)) return true;  // up
        if(search(board, word, idx+1, i, j+1, visited)) return true;  // right
        if(search(board, word, idx+1, i+1, j, visited)) return true;  // down
        if(search(board, word, idx+1, i, j-1, visited)) return true;  // left
        visited.remove(i+"_"+j);  // this last step must be done, either remove from set or reassign board value
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {{'a', 'a'}};
        System.out.println(new Q079().exist(board, "aaa"));
    }
}
