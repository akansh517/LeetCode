class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boatcount=0;
        int left=0;
        int right=people.length-1;
        while(left<=right){
            if(people[left]+people[right]<=limit){
                left++;
                right--;
            }
            else{
                right--;
            }
            boatcount++;
        }
        return boatcount;
    }
}

// T.C:O(nlogn) 
// S.C:O(1)  
