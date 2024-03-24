class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];
        slow=nums[slow];
        fast=nums[nums[fast]];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        // when the cycle is detected then move the slow to the head and move both by one step until they do not meet 
        slow=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
// T.C:O(n)
// S.C:O(1)





// Using Linked list cycle method
class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        } while(slow!=fast);
        fast=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}

// T.C:O(n)
// S.C:O(1)



class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            if(mp.get(nums[i])==2){
                return nums[i];
            }
        }
        return -1;
    }
}

// T.C:O(n)
// S.C:O(n)



// Uisng frequency array i.e hashing
class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int freq[]=new int[n];
        for(int i=0;i<n;i++){
            if(freq[nums[i]]==0){
                freq[nums[i]]++;
            }
            else{
                return nums[i];
            }
        }
        return -1;
    }
}

// T.C:O(n)
// S.C:O(n)


// Using sorting
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==nums[i+1])
                return nums[i];
        }
        return -1;
    }
}

// T.C:O(nlogn)
// S.C:O(1)