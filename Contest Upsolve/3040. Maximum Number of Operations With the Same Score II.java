class Solution {
    int dp[][];
    public int solve(int l,int r,int targetSum,int nums[]){ //targetSum is always fixed for particular op.
        if(l>=r){//if l>=r means only single elemrnt and if l>r then it has already seen that pair 
            return 0;
        }
        if(dp[l][r]!=-1){
            return dp[l][r];
        }
        int ans=0;
        if(nums[l]+nums[l+1]==targetSum){
            ans=Math.max(ans,1+solve(l+2,r,targetSum,nums));//1 is added due to the 1 pair
        }
        if(nums[l]+nums[r]==targetSum){
            ans=Math.max(ans,1+solve(l+1,r-1,targetSum,nums));
        }
        if(nums[r]+nums[r-1]==targetSum){
            ans=Math.max(ans,1+solve(l,r-2,targetSum,nums));
        }
        return dp[l][r]=ans;
    }
    
    public int maxOperations(int[] nums) {
        int n=nums.length;
        dp=new int[n+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        // we can perform basically 3 ops. last2,first2 and first and last element 
        int op1=solve(0,n-1,nums[0]+nums[1],nums);
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int op2=solve(0,n-1,nums[0]+nums[n-1],nums);
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int op3=solve(0,n-1,nums[n-1]+nums[n-2],nums);
        return Math.max(op1,Math.max(op2,op3));
    }
}

// we will figure out all 3 possible targetSum and then try for the values 
// i am applying dp 3 times bcz my targetSum are 3 different targetSum are nums[0]+nums[1]
// nums[n-1]+nums[n-2] and nums[0]+nums[n-1] and for every possible targetSum i have 3 optional
// operations to perform 

// T.C:O(n^2*3)==O(n^2)
// S.C:O(n^2)