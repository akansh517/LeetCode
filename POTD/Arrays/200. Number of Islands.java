class Solution {
    int m;
    int n;
    public void dfs(char grid[][],int i,int j){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0'){  //Base Case
            return ;
        }
        grid[i][j]='0';     //If it is 1 then make it 0 and then call dfs at its 4 pos.
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    dfs(grid,i,j);
                }
            }
        }
        return cnt;
    }
}



// T.C:O(m*n) traversing total nimber of cells in the grid
// S.C:O(m*n) dfs algorithm uses recursion to traverse the grid.
// In the worst case, the maximum depth of the recursion stack is the total number of cells in the grid.