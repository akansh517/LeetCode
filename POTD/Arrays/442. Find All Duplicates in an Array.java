class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int num=Math.abs(nums[i]);
            int idx=num-1;
            if(nums[idx]<0){
                ans.add(num);
            }
            else{
                nums[idx]*=-1;
            }
        }
        return ans;
    }
}

// When the constraints are like this 1 <= nums[i] <= n and nums elements are in the range
// [1,n] then we basically use this pattern in which we treat number as index 
//T.C : O(n)
//S.C : O(1)



class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n=nums.length;
        int freq[]=new int[n+1];
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            freq[num]++;
            if(freq[num]>1 && !set.contains(num)){
                set.add(num);
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int val:set){
            ans.add(val);
        }
        return ans;
    }
}

// T.C:O(n)
// S.C:O(n)