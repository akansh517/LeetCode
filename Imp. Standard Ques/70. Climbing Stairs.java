class Solution {
    int dp[];
    public int solve(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=solve(n-1)+solve(n-2);
        return dp[n];
    }
    public int climbStairs(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }
}
// Top down
// T.C:O(n)
// S.C:O(n)



class Solution {
    public int climbStairs(int n) {
        if(n==1 || n==2){
            return n;
        }
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
// Bottom up
// T.C:O(n)
// S.C:O(n)