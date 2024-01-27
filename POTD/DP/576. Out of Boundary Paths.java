class Solution {
    int M;
    int N;
    int mod=(int)1e9+7;
    int directions[][]={{0,1},{0,-1},{1,0},{-1,0}};
    int dp[][][];
    public int solve(int maxMove,int startRow,int startColumn){
        if(startRow<0 || startRow>=M || startColumn<0 || startColumn>=N){ //find 1 path
            return 1;
        }

        if(maxMove<=0){ //all moves are exhausted 
            return 0;
        }
        if(dp[maxMove][startRow][startColumn]!=-1){
            return dp[maxMove][startRow][startColumn];
        }

        int result=0;
        for(int dir[]:directions){
            int newRow=startRow+dir[0];
            int newColumn=startColumn+dir[1];
            result=(result+solve(maxMove-1,newRow,newColumn))%mod;
        }
        return dp[maxMove][startRow][startColumn]=result%mod;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp=new int[maxMove+1][m+1][n+1];
        for(int i=0;i<maxMove+1;i++){
            for(int j=0;j<m+1;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        M=m;
        N=n;
        return solve(maxMove,startRow,startColumn);
    }
}


// at each cell we have 4 paths so in recursion we have T.C:O(4**maxMove) and we can also go the same cell also if we have some moves more first think of dfs

// Recursion + Memoization using 3D Array
//T.C : O(m * n * maxMove)
//S.C : O(m * n * maxMove) but when we consider the recursion stack space then Height of the tree is also considered in space i.eO(maxMoves) it can go deeply inside the tree



class Solution {
    int M;
    int N;
    int mod=(int)1e9+7;    
    int dp[][][];
    public int solve(int startRow,int startColumn,int maxMove){
        if(startRow<0 || startColumn<0 || startRow>=M || startColumn>=N){
            return 1;
        }

        if(maxMove<=0){
            return 0;
        }

        if(dp[startRow][startColumn][maxMove]!=-1){
            return dp[startRow][startColumn][maxMove];
        }

        int result=0;
        long a=solve(startRow+1,startColumn,maxMove-1)%mod;
        long b=solve(startRow-1,startColumn,maxMove-1)%mod;
        long c=solve(startRow,startColumn+1,maxMove-1)%mod;
        long d=solve(startRow,startColumn-1,maxMove-1)%mod;
        result=(int)((a+b+c+d)%mod);
        return dp[startRow][startColumn][maxMove]=result;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp=new int[m+1][n+1][maxMove+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        M=m;
        N=n;
        return solve(startRow,startColumn,maxMove);
    }
}


