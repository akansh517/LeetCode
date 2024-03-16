class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        int maxLen=0;
        int cumSum=0;
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,-1);
        for(int i=0;i<n;i++){
            // if(nums[i]==0){
            //     cumSum+=-1;
            // }
            // else{
            //     cumSum+=nums[i];
            // }
            cumSum+=(nums[i]==0)?-1:1;
            if(mp.containsKey(cumSum)){
                maxLen=Math.max(maxLen,i-mp.get(cumSum));
            }
            else{//putting into else condn. bcz it will override the cumSum index with the latest cumSum index that will result in shorter length
                mp.put(cumSum,i);
            }
        }
        return maxLen;
    }
}

// T.C:O(n)
// S.C:O(n) due to the map


// Sliding window not working bcz when we are shrinking then one of the zero or ones are decrementing alternatively like testcase 
// [0,1,0,0,0,1,1,1] 
//    i   j    zeros=0,ones=1 when i moves forwards number of ones become 0 due to the shrinkage of window 



class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        int maxLen=0;
        for(int i=0;i<n;i++){
            int ones=0;
            int zeros=0;
            for(int j=i;j<n;j++){
                if(nums[j]==0){
                    zeros++;
                }
                else{
                    ones++;
                }
                if(zeros==ones){
                    maxLen=Math.max(maxLen,j-i+1);
                }
            }
        }
        return maxLen;
    }
}

// T.L.E
// T.C:O(n^2)
// S.C:O(1)