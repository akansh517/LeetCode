class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res=0;
        int minkposition=-1;
        int maxkposition=-1;
        int culp_idx=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<minK || nums[i]>maxK){
                culp_idx=i;
            }
            if(nums[i]==minK){
                minkposition=i;
            }
            if(nums[i]==maxK){
                maxkposition=i;
            }
            int smaller=Math.min(minkposition,maxkposition);
            int temp=smaller-culp_idx;
            res+=(temp<=0)?0:temp;
        }
        return res;
    }
}

// T.C:O(n)  We need one iteration over nums, for each step during the iteration, we need to update some variables which take constant time.
// S.C:O(1) maintaining 4 integer variables minkposition,maxkposition,culp_idx and res 
    