class Solution {
    public int maxSelectedElements(int[] nums) {
        Map<Integer,Integer> dp=new HashMap<>();
        int ans=0;
        Arrays.sort(nums);
        for(int el:nums){
            dp.put(el+1,dp.getOrDefault(el,0)+1);
            dp.put(el,dp.getOrDefault(el-1,0)+1);
            ans=Math.max(ans,Math.max(dp.get(el+1),dp.get(el)));
        }
        return ans;
    }
}
// Relate with LIS
// T.C:O(nlogn) due to the sorting
// S.C:O(n) due to the map which is used for storing all the dp values 


// dp[el]=Maximum length of consecutive sequence ending at el
// first op. i will do dp[el+1]=dp[el]+1 bcz it will not modify and trying to access dp[el]
// 2nd op. if i will do dp[el]=dp[el-1]+1 it is trying to access dp[el-1] due to which
// it will modify the value that will be incorrect so that i will perform 1 op.

// here in this prob. constraints are small 1e6 so i can also use the array for storing the values
// otherwise if constraints are large then i have to use the unordered map in that case 

// class Solution {
//     public int maxSelectedElements(int[] nums) {
//         int dp[]=new int[(int)1e6+1];
//         int ans=0;
//         Arrays.sort(nums);
//         for(int el:nums){
//             dp[el+1]=dp[el]+1;
//             dp[el]=dp[el-1]+1;
//             ans=Math.max(ans,Math.max(dp[el+1],dp[el]));
//         }
//         return ans;
//     }
// }

