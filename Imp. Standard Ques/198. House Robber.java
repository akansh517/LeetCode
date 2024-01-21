class Solution {
    int n;
    int dp[];
    public int solve(int i,int nums[]){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int steal=nums[i]+solve(i+2,nums);
        int skip=solve(i+1,nums);
        return dp[i]=Math.max(steal,skip);
    }
    public int rob(int[] nums) {
        n=nums.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,nums);
    }
}

// T.C: == S.C: == O(n)






// class Solution {
//     int n;
//     int dp[];
//     public int solve(int i,int nums[]){
//         if(i>=n){
//             return 0;
//         }
//         if(dp[i]!=-1){
//             return dp[i];
//         }
//         int take=nums[i]+solve(i+2,nums);
//         int skip=solve(i+1,nums);
//         return dp[i]=Math.max(take,skip);
//     }
//     public int rob(int[] nums) {
//         if(nums.length==1){
//             return nums[0];
//         }
//         if(nums.length==2){
//             return Math.max(nums[0],nums[1]);
//         }
//         n=nums.length;
//         dp=new int[n+1];
//         Arrays.fill(dp,-1);
//         return solve(0,nums);
//     }
// }