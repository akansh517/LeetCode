class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        int k=0;
        for(int i=0;i<n;i++){
            int prod=1;
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                else{
                    prod*=nums[j];
                }
            }
            ans[k++]=prod;
        }
        return ans;
    }
}


// T.C:O(n^2)
// S.C:O(1) The output array does not count as extra space for space complexity analysis