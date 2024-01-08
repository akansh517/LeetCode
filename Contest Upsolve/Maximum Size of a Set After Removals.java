class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n=nums1.length;
        Set<Integer> st1=new HashSet<>();
        
        for(int num:nums1){
            st1.add(num);
        }
        Set<Integer> st2=new HashSet<>();
        Set<Integer> common=new HashSet<>();
        for(int num:nums2){
            st2.add(num);
            if(st1.contains(num)){
                common.add(num);
            }
        }

        int n1=st1.size();
        int n2=st2.size();
        int c=common.size();
        int ans=Math.min(n,Math.min(n1-c,n/2)+Math.min(n2-c,n/2)+c);
        return ans;
    }
}

// T.C:O(2n)==O(n)
// S.C:O(n)