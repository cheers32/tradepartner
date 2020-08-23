package Q100_Q149;

public class Q130 {
    public void solve(char[][] board) {  // N^2 -> N solution, every cell visited exactly once; this is not difficult to think and write
        if(board==null || board.length==0)
            return;
        for(int i=0; i<board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length-1);

        }
        for(int j=0; j<board[0].length; j++) {
            dfs(board, 0, j);
            dfs(board, board.length-1, j);
        }
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='*')
                    board[i][j]='O';
            }
        }
    }

    void dfs(char[][] board, int i, int j) {
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1)
            return;
        if(board[i][j]=='X' || board[i][j]=='*')
            return;
        board[i][j]='*';
        dfs(board, i-1, j);
        dfs(board, i, j-1);
        dfs(board, i+1, j);
        dfs(board, i, j+1);
    }

    public static void main(String[] args) {
        char[][] input = new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new Q130().solve(input);
    }
}
