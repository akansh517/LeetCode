class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j]=grid[i][j];
                }
                else if(i==0){
                    dp[i][j]+=dp[i][j-1]+grid[i][j];
                }
                else if(j==0){
                    dp[i][j]+=dp[i-1][j]+grid[i][j];
                }
                else{
                    dp[i][j]+=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+grid[i][j];
                }
                if(dp[i][j]<=k){
                    ans++;
                }
            }
        }
        return ans;
    }
}

// T.C:O(m*n)
// S.C:O(m*n)