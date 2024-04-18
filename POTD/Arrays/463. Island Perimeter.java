class Solution {
    public int islandPerimeter(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int peri=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)   continue;
                if(i-1<0 || grid[i-1][j]==0){
                    peri++;
                }
                if(i+1>=m || grid[i+1][j]==0){
                    peri++;
                }
                if(j-1<0 || grid[i][j-1]==0){
                    peri++;
                }
                if(j+1>=n || grid[i][j+1]==0){
                    peri++;
                }
            }
        }
        return peri;
    }
}

// T.C:O(m*n)
// S.C:O(1)


class Solution {
    int peri=0;
    int m;
    int n;
    public void solve(int[][] grid,int i,int j){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0){
            peri++;
            return;
        }
        if(grid[i][j]==-1){
            return;
        }

        grid[i][j]=-1;//marked visited
        
        solve(grid,i+1,j);
        solve(grid,i-1,j);
        solve(grid,i,j+1);
        solve(grid,i,j-1);
    }
    public int islandPerimeter(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    solve(grid,i,j);
                    return peri;
                }
            }
        }
        return -1;
    }
}

// Usinmg DFS
// T.C:O(m*n)
// S.C:O(1)