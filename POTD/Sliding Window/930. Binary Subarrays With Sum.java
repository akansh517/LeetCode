class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int i=0;
        int j=0;
        int windowSum=0;
        int n=nums.length;
        int result=0;
        int countZero=0;
        while(j<n){
            windowSum+=nums[j];
            while(i<j && (windowSum>goal || nums[i]==0)){
                if(nums[i]==0){
                    countZero++;
                }
                else{
                    countZero=0;
                }
                windowSum-=nums[i];
                i++;
            }

            if(windowSum==goal){
                result+=1+countZero;
            }
            j++;
        }
        return result;
    }
}

// This could be a straightforward sliding window but the presence of 0 makes it a little tricky.
// Example: [0, 0, 0, 1, 1] -> Total subarrays having goal = 2
// will be 4 - {0, 0, 0, 1, 1}, {0, 0, 1, 1}, {0, 1, 1}, {1, 1}
// So, simply find the count of zeros before the sum has reached the goal i.e.
// , 3 (Now, 1+1 = goal, so total subarrays = prefix_zeros + 1 = 3 + 1 = 4)
// T.C: O(n)
// S.C: O(1)


class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        int n=nums.length;
        int ans=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int rem=sum-goal;
            if(mp.containsKey(rem)){
                ans+=mp.get(rem);
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
// T.C:O(n)
// S.C:O(n) due to the map



// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         int n=nums.length;
//         int ans=0;
//         for(int i=0;i<n;i++){
//             int sum=0;
//             for(int j=i;j<n;j++){
//                 sum+=nums[j];
//                 if(sum==goal){
//                     ans++;
//                 }
//             }
//         }
//         return ans;
//     }
// }

// T.C:O(n^2)
// S.C:O(1)



// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         int n=nums.length;
//         int ans=0;
//         for(int i=0;i<n;i++){
//             for(int j=i;j<n;j++){
//                 int sum=0;
//                 for(int k=i;k<=j;k++){
//                     sum+=nums[k];
//                 }
//                 if(sum==goal){
//                     ans++;
//                 }
//             }
//         }
//         return ans;
//     }
// }
// T.L.E 
// T.C:O(n^3)
// S.C:O(1)

