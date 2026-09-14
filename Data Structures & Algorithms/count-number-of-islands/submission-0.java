class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    cnt++;
                    dfs(grid, i, j, n, m, vis);
                }
            }
        }
        return cnt;
    }

    public void dfs(char grid[][], int i, int j, int n, int m, int[][] vis){
        vis[i][j]=1;
        if(i > 0 && grid[i-1][j]=='1' && vis[i-1][j]==0){
            dfs(grid, i-1, j, n, m, vis);
        }
        if(j > 0 && grid[i][j-1]=='1' && vis[i][j-1]==0){
            dfs(grid, i, j-1, n, m, vis);
        }
         if(i < n-1 && grid[i+1][j]=='1' && vis[i+1][j]==0){
            dfs(grid, i+1, j, n, m, vis);
        }
        if(j < m-1 && grid[i][j+1]=='1' && vis[i][j+1]==0){
            dfs(grid, i, j+1, n, m, vis);
        }
    }
}
