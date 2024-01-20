class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int dp[][]=new int[n][n];
        for(int col=0;col<n;col++){
            dp[0][col]=matrix[0][col];
        }

        for(int row=1;row<n;row++){
            for(int col=0;col<n;col++){
                int a=Integer.MAX_VALUE;
                int b=Integer.MAX_VALUE;
                if(col-1>=0){
                    a=dp[row-1][col-1];
                }
                if(col+1<n){
                    b=dp[row-1][col+1];
                }
                dp[row][col]=matrix[row][col]+Math.min(dp[row-1][col],Math.min(a,b));
            }
        }

        int result=Integer.MAX_VALUE;
        int lastRow=n-1;
        for(int col=0;col<n;col++){
            result=Math.min(dp[lastRow][col],result);
        }
        return result;
    }
}

// T.C:O(n^2)
// S.C:O(n^2)










// class Solution {
//     int n;
//     int dp[][];
//     public int solve(int i,int j,int matrix[][]){
//         if(i==n-1){
//             return matrix[i][j];
//         }
//         if(dp[i][j]!=-1){
//             return dp[i][j];
//         }
//         int minSum=Integer.MAX_VALUE;
//         // if(i+1<n){
//         //     minSum=Math.min(minSum,matrix[i][j]+solve(i+1,j,matrix));
//         // }
//         // if(i+1<n && j+1<n){
//         //     minSum=Math.min(minSum,matrix[i][j]+solve(i+1,j+1,matrix));
//         // }
//         // if(i+1<n && j-1>=0){
//         //     minSum=Math.min(minSum,matrix[i][j]+solve(i+1,j-1,matrix));
//         // }
        
//         // OR

//         // {col+1,col-1,col}  {+1,-1,0}
//         for(int shift=-1;shift<=1;shift++){
//             if(i+1<n && shift+j>=0 && shift+j<n){
//                 minSum=Math.min(minSum,matrix[i][j]+solve(i+1,j+shift,matrix));
//             }
//         }
//         return dp[i][j]=minSum;
//     }
//     public int minFallingPathSum(int[][] matrix) {
//         n=matrix.length;
//         dp=new int[n+1][n+1];
//         for(int row[]:dp){
//             Arrays.fill(row,-1);
//         }
//         int row=0;
//         int minSum=Integer.MAX_VALUE;
//         for(int col=0;col<n;col++){
//             minSum=Math.min(minSum,solve(row,col,matrix));
//         }
//         return minSum;
//     }
// }
// T.L.E:49/50

// T.C:O(n^2)
// S.C:O(n^2)