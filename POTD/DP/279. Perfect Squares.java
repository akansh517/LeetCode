class Solution {
    int dp[];
    public int helper(int n){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        // We can select only those perfect squares which can contribute to sum up to n
        int minCount=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int result=1+helper(n-i*i);//added 1 bcz we have selecetd 1 square no.
            minCount=Math.min(minCount,result);
        }
        return dp[n]=minCount;
    }
    public int numSquares(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n);
    }
}


//T.C : O(n * sqrt(n))
//S.C : O(n)