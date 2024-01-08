class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        Map<Long,Integer>[] mp=new HashMap[n]; //Array Of Map of size n 
        int result=0;
        for(int i=0;i<n;i++){
            mp[i]=new HashMap<>();
            for(int j=0;j<i;j++){
                long diff=(long)nums[i]-nums[j];
                int count_at_j=mp[j].getOrDefault(diff,0); //finding the diff in prev index mp if we have founded the diff then add in the current map index array and put the previous map index array in result because it is contributing to get subsequence.
                result+=count_at_j;
                mp[i].put(diff,mp[i].getOrDefault(diff,0)+count_at_j+1);
            }
        }
        return result;
    }
}


// The intutition behind this approach is basically we are finding the current index subsequence from the past index subsequence if it contains the diff in the past then it means it is contributing in the result 
// here diff is the key in map and its freq. is the value in the map
// so we are basically storing d -> count of subsequences 
// and also
// and we are not take care of 3 length bcz as we see "result += count_at_j" , where count_at_j is the freq of the prev diff. So we're only updating result when we have already encountered it previously. So two pairs, one common = three numbers.

//T.C : O(n^2)
//S.C : O(n^2) - because of the 2D array mp, where each row mp[i] represents a different index in the input vector nums