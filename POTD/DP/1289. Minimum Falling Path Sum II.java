class Solution {
    int n;
    int dp[][];
    public int solve(int col,int row,int grid[][]){
        if(row==n-1){ //base case 
            return grid[row][col];
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int ans=Integer.MAX_VALUE;
        for(int nextCol=0;nextCol<n;nextCol++){
            if(nextCol!=col){
                ans=Math.min(ans,solve(nextCol,row+1,grid));
            }
        }
        return dp[row][col]=ans+grid[row][col];
    }
    public int minFallingPathSum(int[][] grid) {
        n=grid.length;
        dp=new int[n+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int result=Integer.MAX_VALUE;
        for(int col=0;col<n;col++){
            result=Math.min(result,solve(col,0,grid));
        }
        return result;
    }
}


//Approach-1 (Recur + Memoization)
//T.C : O(N^3)
//S.C : O(N^2)


// Without memo we will try for all possibilities for each col so n^n and inside the rs.ecurss.ion we are running one loop that costsO(n) so overall complexity becomes O(n^n)*n and the  S.C will be O(depth) incase of recursive stack space but if we use auxilary stack space that will be O(1)