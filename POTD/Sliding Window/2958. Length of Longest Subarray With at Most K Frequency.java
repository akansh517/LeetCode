class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> mp=new HashMap<>();
        int j=0;
        int i=0;
        int max=Integer.MIN_VALUE;
        while(j<n){ 
            mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
            while(mp.get(nums[j])>k){
                mp.put(nums[i],mp.get(nums[i])-1);
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}

// T.C:O(n+n) ==O(n)
// i and j are iterating n times
// S.C:O(n) due to the map data structure


class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> mp=new HashMap<>();
        int j=0;
        int i=0;
        int max=Integer.MIN_VALUE;
        while(j<n){ 
            mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
            if(mp.get(nums[j])<=k){
                max=Math.max(max,j-i+1);
            }
            while(mp.get(nums[j])>k){
                mp.put(nums[i],mp.get(nums[i])-1);
                i++;
            }
            j++;
        }
        return max;
    }
}

