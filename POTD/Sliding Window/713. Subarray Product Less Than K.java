class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int ans=0;
        int prod=1;
        int i=0;
        int j=0;
        // Handle edge cases where k is 0 or 1 (no subarrays possible)
        if(k<=1){
            return 0;
        }
        while(j<n){
            prod*=nums[j];
            // Shrink the window from the left while the product is greater than or equal to k
            while(prod>=k){
                prod/=nums[i];
                i++;
            }
            ans+=j-i+1;//No. of subarrays ending at j
            j++;
        }
        return ans;
    }
}

// T.C:O(n) Each element is visited atmost twice in nums array
// S.C:O(1)




class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int prod=1;
            for(int j=i;j<n;j++){
                prod*=nums[j];
                if(prod<k){
                    ans++;
                }
                else{
                    break;
                }
            }
        }
        return ans;
    }
}

// T.C:O(n^2)
// S.C:O(1)
