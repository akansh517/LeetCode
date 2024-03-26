class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        boolean contains1=false;
        // Check whether 1 is in the original array
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                contains1=true;
            }
            if(nums[i]<=0 || nums[i]>n){
                nums[i]=1;
            }
        }

        if(contains1==false){
            return 1;
        }
        // Mark whether integers 1 to n are in nums
        // Use index as a hash key and negative sign as a presence detector.
        for(int i=0;i<n;i++){
            int num=Math.abs(nums[i]);
            int idx=num-1;
            if(nums[idx]<0) continue;
            nums[idx]*=-1;
        }
        // First positive in nums is smallest missing positive integer
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                return i+1;
            }
        }

        return n+1;

    }
}
// if numbers are in the range[1,n] then n+1 will be my first missing +ve number and in this pattern we will "Using numbers as indices"
// T.C:O(n)
// S.C:O(1)


class Solution {
    public int firstMissingPositive(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int num:nums){
            maxi=Math.max(maxi,num);
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        if(maxi<0){
            return 1;
        }
        System.out.println(mp);
        for(int i=1;i<=maxi;i++){
            if(!mp.containsKey(i)){
                return i;
            }
        }
        return maxi+1;
    }
}

// T.C:O(n)
// S.C:O(n)