class Solution {
    int n;
    int dp[];
    public int solve(int i,int arr[],int k){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int result=0;
        int currMax=-1;
        for(int j=i;j<n && j-i+1<=k;j++){
            currMax=Math.max(currMax,arr[j]);
            result=Math.max((currMax*(j-i+1))+solve(j+1,arr,k),result);
        }   
        return dp[i]=result; 
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        n=arr.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,arr,k);
    }
}


// Recursion + Memo
//T.C : With Memoization - O(n*k) -> We visit only n states in dp array and everytime run a for loop of size k
//      Without Memoization - We have k options at each index - O(k^n) - Since the recursion tree has a branching factor of k, and the depth of the recursion tree is at most n
//S.C : O(n)