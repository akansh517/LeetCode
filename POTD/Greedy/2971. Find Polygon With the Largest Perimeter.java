class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long remainingElementsSum=0;
        long ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(remainingElementsSum>nums[i]){
                ans=remainingElementsSum+nums[i];
            }
            remainingElementsSum+=nums[i];
        }
        return ans==0?-1:ans;
    }
}


// T.C:O(nlogn+n)==O(nlogn) due to the sorting
// S.C:(logn)