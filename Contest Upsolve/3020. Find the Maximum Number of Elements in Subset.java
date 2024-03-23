class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer,Integer> mp=new HashMap<>(); //O(n)
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        int n=nums.length;
        int maxi=mp.containsKey(1)?((mp.get(1)%2==0)?mp.get(1)-1:mp.get(1)):1;
        for(int i=0;i<n;i++){ //O(n)
            int val=nums[i];
            int cnt=0;
            while(val<=(int)1e9 && val!=1 && mp.containsKey(val) && mp.get(val)>=2){
                cnt+=2;
                val*=val;
            }
            if(mp.containsKey(val)){
                cnt++;
            }
            else{
                cnt--;
            }
            maxi=Math.max(maxi,cnt);
        }
        return maxi;
    }
}



// T.C:O(n)The overall time complexity is dominated by the second loop, which iterates through each element in nums and performs constant-time operations (checking map presence, squaring, etc.). Therefore, the time complexity is O(n).
// S.C:O(n)Since the map stores the frequency of each distinct element in nums