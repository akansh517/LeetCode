class Solution {
    int mod=(int)1e9+7;
    int dp[][];
    public int solve(int n,int k){
        if(n==0){   //when the length becomes 0 i.e no element present in the array so return 0
            return 0;
        }
        if(k==0){ //we have only one possibility i.e sorted array when k==0
            return 1;
        }
        if(dp[n][k]!=-1){
            return dp[n][k];
        }
        int result=0;
        // In an array of length n, we can't create inversions more than (n-1) -> min(n-1, k)
        for(int inv=0;inv<=Math.min(n-1,k);inv++){
            result=(result%mod+solve(n-1,k-inv)%mod)%mod;
        }
        return dp[n][k]=result;
    }
    public int kInversePairs(int n, int k) {
        dp=new int[n+1][k+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return solve(n,k);
    }
}

// Recursion T.C:O(K^n) for every n i am trying k possibilities
// (Reucr+Memo)
//T.C  : O(n*k*n) In worst case for loop runs almost k times and inside this for loop it is calling solve repeatedly until n not becomes 0 or k not becomes 0
//S.C  : O(n*k) for memo + Recursion call stack