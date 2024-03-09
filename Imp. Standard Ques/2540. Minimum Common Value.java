class Solution {
    public boolean binarySearch(int target,int nums2[]){
        int l=0;
        int r=nums2.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums2[mid]==target){
                return true;
            }
            else if(nums2[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return false;
    }
    public int getCommon(int[] nums1, int[] nums2) {
        for(int num:nums1){
            if(binarySearch(num,nums2)){
                return num;
            }
        }
        return -1;
    }
}


// Using Binary Search
//T.C : O(mlogn)
//S.C : O(1)



class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int i=0;
        int j=0;
        while(i<m && j<n){
            if(nums1[i]==nums2[j]){
                return nums1[i];
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                i++;
            }
        }
        return -1;
    }
}

// Using 2 ptr
//T.C : O(m+n)
//S.C : O(1)




class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums2){
            if(set1.contains(num)){
                return num;
            }
        }
        return -1;
    }
}

// Creating set1 takes O(n).
// We search for each element of nums2 in set1. Searching for an element in a hash set takes 
// O(1) on average, so the time complexity of this step is O(m) where m is the length of nums2.
// T.C:O(m+n)
// S.C:O(n)