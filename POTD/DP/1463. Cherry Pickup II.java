class Solution {
    int m;
    int n;
    int dp[][][];
    public int solve(int row,int col1,int col2,int grid[][]){
        if(row>=m){
            return 0;
        }
        if(dp[row][col1][col2]!=-1){
            return dp[row][col1][col2];
        }
        int col_dir[]={-1,0,1};
        int cherry=grid[row][col1];
        if(col1!=col2){//When both robots stay in the same cell, only one takes the cherries checking this condition
            cherry+=grid[row][col2];
        }

        int ans=0;
        for(int x=-1;x<=1;x++){
            for(int y=-1;y<=1;y++){
        // for(int x:col_dir){
        //     for(int y:col_dir){
            
                int newRow=row+1;
                int newCol1=x+col1;
                int newCol2=y+col2;
                if(newCol1>=0 && newCol1<n && newCol2>=0 && newCol2<n){
                    ans=Math.max(ans,solve(newRow,newCol1,newCol2,grid));
                }
            }
        }
        return dp[row][col1][col2]=cherry+ans;
    }
    public int cherryPickup(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        dp=new int[m+1][n+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(0,0,n-1,grid);
    }
}


//T.C : O(row*col*col * 9) -> 9 is from the double for loop for {-1,0,1}
//S.C : O(row * col * col)