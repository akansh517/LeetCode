class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);// sort the array so that they are in sequence 
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int prevIdx[]=new int[n];   //maintaining the lastIdx from which i got greater subset
        Arrays.fill(prevIdx,-1);
        int lastChosenIdx=0;    //keep track of index at which max ans found which helps to find ans by backtracking 
        int maxLen=1;   //maximum Length of subset maintained with this variable 
        //Just need to keep track of how to print LIS
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){ //division prop
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        prevIdx[i]=j;
                    }
                    if(dp[i]>maxLen){
                        maxLen=dp[i];
                        lastChosenIdx=i;
                    }
                }
            }
        }

        List<Integer> result=new ArrayList<>();
        while(lastChosenIdx>=0){
            result.add(nums[lastChosenIdx]);
            lastChosenIdx=prevIdx[lastChosenIdx];
        }
        return result;
    }
}

// T.C:O(n^2)
// S.C:O(n)









// class Solution {
//     int n;
//     public void solve(int idx,List<Integer> temp,int nums[],int prev,List<Integer> result){
//         if(idx>=n){
//             if(temp.size()>result.size()){
//                 result.clear();
//                 result.addAll(temp);
//             }
//             return;
//         }

//         if(prev==-1 || nums[idx]%prev==0){
//             temp.add(nums[idx]);
//             solve(idx+1,temp,nums,nums[idx],result);
//             temp.remove(new Integer(nums[idx]));
//         }

//         solve(idx+1,temp,nums,prev,result);
        
//     }
//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         n=nums.length;
//         Arrays.sort(nums);
//         List<Integer> temp=new ArrayList<>();
//         List<Integer> result=new ArrayList<>();
//         solve(0,temp,nums,-1,result);
//         return result;
//     }
// }

// T.L.E
// T.C:O(2^n) bcz at each index we have 2 options 
// S.C:O(n)