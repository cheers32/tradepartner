package Q200_Q249;

public class Q200 {
    public int numIslands(char[][] grid) { // very standard dfs, N; longlong's notes has an example of union find, can take a look, using map
        // also remembered my expiring keys, can use linked hashmap, can take a further look
        if(grid == null)
            return 0;
        int res = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='1') {
                    dfs(grid, i, j);
                    res += 1;
                }
            }
        }
        return res;
    }

    void dfs(char[][] grid, int i, int j) {
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1)
            return;
        if(grid[i][j]=='1') {
            grid[i][j] = '2';
            dfs(grid, i-1, j);
            dfs(grid, i, j+1);
            dfs(grid, i+1, j);
            dfs(grid, i, j-1);
        }
    }
}
