class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> arr=new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m=nums1.length;
        int n=nums2.length;
        int i=0;
        int j=0;
        while(i<m && j<n){
            if(nums1[i]==nums2[j]){
                arr.add(nums1[i]);
                while(i<m-1 && nums1[i]==nums1[i+1]){
                    i++;
                }
                while(j<n-1 && nums2[j]==nums2[j+1]){
                    j++;
                }
                i++;
                j++;
            }
            
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                i++;
            }
        }
        
        int ans[]=new int[arr.size()];
        int k=0;
        for(int val:arr){
            ans[k++]=val;
        }
        return ans;
    }
}

// Sorting and two-pointers
//T.C : O(n + m + nlogn + mlogm)
//S.C : O(1)



class Solution {
    public boolean binarySearch(int target,int nums[]){
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                return true;
            }
            else if(nums[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return false;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> arr=new HashSet<>();
        Arrays.sort(nums1);
        for(int num:nums2){
            if(binarySearch(num,nums1)){
                arr.add(num);
            }
        }
        
        int ans[]=new int[arr.size()];
        int i=0;
        for(int val:arr){
            ans[i++]=val;
        }
        return ans;
    }
}

// Sorting and binary search
//T.C : O(n + mlogm)
//S.C : O(n)




class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        List<Integer> arr=new ArrayList<>();
        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums2){
            if(set1.contains(num)){
                arr.add(num);
                set1.remove(num);
            }   
        }
        int ans[]=new int[arr.size()];
        int i=0;
        for(int val:arr){
            ans[i++]=val;
        }
        return ans;
    }
}

// T.C=>O(m+n)
// S.C:O(m+l) where l is the size of the arr


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums2){
            if(set1.contains(num)){
                set2.add(num);
            }   
        }
        int ans[]=new int[set2.size()];
        int i=0;
        for(int val:set2){
            ans[i++]=val;
        }
        return ans;
    }
}

// T.C=S.C=>O(m+n)