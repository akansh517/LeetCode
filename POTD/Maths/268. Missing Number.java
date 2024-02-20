class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int result=n;
        for(int i=0;i<n;i++){
            result=result^i;
            result=result^nums[i];
        }
        return result;
    }
}

// we know xor of all equal(a^a=0) elements equal to 0 
// T.C:O(n)
// S.C:O(1)




// class Solution {
//     public int missingNumber(int[] nums) {
//         Arrays.sort(nums);
//         int n=nums.length;
//         int l=0;
//         int r=n-1;
//         int result=n;
//         while(l<=r){
//             int mid=l+(r-l)/2;
//             if(nums[mid]>mid){
//                 result=mid;
//                 r=mid-1;
//             }
//             else{
//                 l=mid+1;
//             }
//         }
//         return result;
//     }
// }

// T.C:O(nlogn)
// S.C:O(1)




// class Solution {
//     public int missingNumber(int[] nums) {
//         int n=nums.length;
//         int totalSum=(n*(n+1))/2;
//         int arrSum=0;
//         for(int i=0;i<n;i++){
//             arrSum+=nums[i];
//         }
//         return totalSum-arrSum;
//     }
// }

// T.C:O(n)
// S.C:O(1)								
								
								
							



// class Solution {
//     public int missingNumber(int[] nums) {
//         Map<Integer,Integer> mp=new HashMap<>();
//         for(int i:nums){
//             mp.put(i,mp.getOrDefault(i,0)+1);
//         }
//         for(int i=0;i<=nums.length;i++){
//             if(mp.get(i)==null){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }

// T.C:O(n)
// S.C:O(n) due to the map 





// class Solution {
//     public int missingNumber(int[] nums) {
//         Arrays.sort(nums);
//         int n=nums.length;
//         for(int i=0;i<n;i++){
//             if(nums[i]!=i)
//                 return i;
//         }
//         return n;
//     }
// }
// linear searching
// T.C:O(nlogn)
// S.C:O(1)