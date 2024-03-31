class Solution {  
    public long countSubarrays(int[] nums, int k) {
        int i=0;
        int j=0;
        Map<Integer,Integer> mp=new HashMap<>();
        long ans=0;
        int max=Integer.MIN_VALUE;
        int n=nums.length;

        for(int num:nums){
            max=Math.max(max,num);
        }

        while(j<n){
            mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
                while(mp.get(max)!=null && mp.get(max)>=k){
                    ans+=n-j;
                    mp.put(nums[i],mp.get(nums[i])-1);
                    i++;
                }
            j++;
        }
        return ans;
    }
}

// T.C:O(n+n)==O(n)
// i and j will iterate n times
// S.C:O(1)



class Solution {
    public long countSubarrays(int[] nums, int k) {
        int i=0;
        int j=0;
        int cnt=0;
        long ans=0;
        int max=Integer.MIN_VALUE;
        int n=nums.length;

        for(int num:nums){
            max=Math.max(max,num);
        }

        while(j<n){
            if(nums[j]==max){
                cnt++;
            }
            if(cnt>=k){
                while(cnt>=k){
                    ans+=n-j;
                    if(nums[i]==max){
                        cnt--;
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}



// // T.C:O(n+n)==O(n)
// // i and j will iterate n times
// // S.C:O(1)



class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans=0;
        int i=0;
        int j=0;
        int n=nums.length;
        int cnt=0;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(max,num);
        }
        while(j<n){
            if(nums[j]==max){
                cnt++;
            }
            if(cnt>=k){
                while(cnt>=k){
                    if(nums[i]==max){
                        cnt--;
                    }
                    i++;
                }
                ans+=i;   
            }
            j++; 
        }
        return ans;
    }
}

 
class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans=0;
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(num,max);
        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int cnt=0;
                for(int m=i;m<=j;m++){
                    if(nums[m]==max){
                        cnt++;
                    }
                }
                if(cnt>=k){
                    ans++;
                }
            }
        }
        return ans;
    }
}

// Brute Force
// T.C: O(n^3)
