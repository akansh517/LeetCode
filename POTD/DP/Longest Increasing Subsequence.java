class Solution {
    public int binarySearch(List<Integer> sorted,int target){
        int left=0;
        int right=sorted.size();
        int ans=sorted.size();
        while(left<right){
            int mid=left+(right-left)/2;
            if(sorted.get(mid)<target){
                left=mid+1;
            }
            else{
                ans=mid;
                right=mid;
            }
        }
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        List<Integer> sorted=new ArrayList<>();
        for(int i=0;i<n;i++){   //O(n)
            int index=binarySearch(sorted,nums[i]);
            if(index==sorted.size()){  //we get greater element than nums[i] //O(logn)
                sorted.add(nums[i]);
            }
            else{                      //Replace nums[i] with just smaller element
                sorted.set(index,nums[i]);
            }
        }
        return sorted.size();
    }
}

// T.C:O(nlogn)  we are doing traversal on array and while doing traversal we are finding the lower bound for each element that costs O(logn) so Overall T.C becomes O(nlogn)
// S.C:O(n) due to the sorted Arraylist

// The algo. named is Patience Sorting algo.

/*  
    Why lower bound?
    We want an increasing subsequence, and hence
    we want to eliminate the duplicates as well.
    lower_bound returns the index of "next greater or equal to."
*/






// class Solution {
//     int n;
//     int dp[][];
//     public int solve(int nums[],int i,int prev){
//         if(i>=n){
//             return 0;
//         }
//         if(prev!=-1 && dp[i][prev]!=-1){
//             return dp[i][prev];
//         }
//         int take=0;
//         int skip=0;
//         if(prev==-1 || nums[i]>nums[prev]){
//             take=solve(nums,i+1,i) + 1;
//         }
//         skip=solve(nums,i+1,prev); 
//         if(prev!=-1){
//             dp[i][prev]=Math.max(take,skip);
//         }
//         return Math.max(take,skip);
//     }
//     public int lengthOfLIS(int[] nums) {
//         n=nums.length;
//         dp=new int[n+1][n+1];
//         for(int row[]:dp){
//             Arrays.fill(row,-1);
//         }
//         return solve(nums,0,-1);
//     }
// }
// T.C:O(n^2)
// S.C:O(n^2)










// class Solution {
//     public int lengthOfLIS(int[] nums,int size) {
//         ArrayList<Integer> arr=new ArrayList<>();
//         arr.add(nums[0]);
//         int len=1;
//         int n=nums.length;
//         for(int i=1;i<n;i++){
//             if(nums[i]>arr.get(arr.size()-1)){
//                 arr.add(nums[i]);
//                 len++;
//             }
//             else{
//                 int index=binarysearch(arr,nums[i]);
//                 arr.set(index,nums[i]);
//             }
//         }
//         return len;
//     }
//     public int lengthOfLIS(int nums[]){
//         return lengthOfLIS(nums,0);
//     }
//     public int binarysearch(ArrayList<Integer> arr,int key){
//         int low=0;
//         int high=arr.size()-1;
//         while(low<=high){
//             int mid=low+(high-low)/2;
//             if(arr.get(mid)==key){
//                 return mid;
//             }
//             else if(arr.get(mid)>key){
//                 high=mid-1;
//             }
//             else{
//                 low=mid+1;
//             }
//         }
//         return high+1;
//     }
// }

// T.C:O(nlogn)




// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n=nums.length;
//         int dp[]=new int[n];
//         for(int i=0;i<n;i++){
//             dp[i]=1;
//         }
//         int ans=1;
//         for(int i=1;i<n;i++){
//             for(int j=0;j<i;j++){
//                 if(nums[j]<nums[i]){
//                 dp[i]=Math.max(dp[i],1+dp[j]);
//             }
//             }
//             ans=Math.max(ans,dp[i]);
//         }
//         return ans;
//     }
// }

// T.C:O(n^2)