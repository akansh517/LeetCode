class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        int ans=0;
        for(int i:mp.values()){
            if(i==1){
                return -1;
            }
            // ans+=Math.ceil((double)i/3);
            ans+=(i%3==0)?i/3:i/3+1;
        }
        return ans;
    }
}


// T.C:O(n) Iterating over nums to count each number will incur a time complexity of O(n). The subsequent loop iterating over counter will also incur a time complexity of O(n) since there could be at most n unique elements in the hash map.

// S.C:O(n) mp will incur a space complexity of O(n) since there could be at most n elements stored in the hash map in the worst-case scenario.




// class Solution {
//     public int minOperations(int[] nums) {
//         Map<Integer,Integer> mp=new HashMap<>();
//         for(int num:nums){
//             mp.put(num,mp.getOrDefault(num,0)+1);
//         }
//         int ans=0;
//         for(int i:mp.keySet()){
//             if(mp.get(i)==1){
//                 return -1;
//             }
//             ans+=Math.ceil((double)mp.get(i)/3);
//         }
//         return ans;
//     }
// }


// T.C:O(n) Iterating over nums to count each number will incur a time complexity of O(n). The subsequent loop iterating over counter will also incur a time complexity of O(n) since there could be at most n unique elements in the hash map.

// S.C:O(n) mp will incur a space complexity of O(n) since there could be at most n elements stored in the hash map in the worst-case scenario.
=======
class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        int ans=0;
        for(int i:mp.values()){
            if(i==1){
                return -1;
            }
            // ans+=Math.ceil((double)i/3);
            ans+=(i%3==0)?i/3:i/3+1;
        }
        return ans;
    }
}


// T.C:O(n) Iterating over nums to count each number will incur a time complexity of O(n). The subsequent loop iterating over counter will also incur a time complexity of O(n) since there could be at most n unique elements in the hash map.

// S.C:O(n) mp will incur a space complexity of O(n) since there could be at most n elements stored in the hash map in the worst-case scenario.




// class Solution {
//     public int minOperations(int[] nums) {
//         Map<Integer,Integer> mp=new HashMap<>();
//         for(int num:nums){
//             mp.put(num,mp.getOrDefault(num,0)+1);
//         }
//         int ans=0;
//         for(int i:mp.keySet()){
//             if(mp.get(i)==1){
//                 return -1;
//             }
//             ans+=Math.ceil((double)mp.get(i)/3);
//         }
//         return ans;
//     }
// }


// T.C:O(n) Iterating over nums to count each number will incur a time complexity of O(n). The subsequent loop iterating over counter will also incur a time complexity of O(n) since there could be at most n unique elements in the hash map.

// S.C:O(n) mp will incur a space complexity of O(n) since there could be at most n elements stored in the hash map in the worst-case scenario.

