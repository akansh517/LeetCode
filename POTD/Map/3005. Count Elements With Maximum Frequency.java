class Solution {
    public int maxFrequencyElements(int[] nums) {
        int total=0;
        int maxFreq=0;
        int arr[]=new int[101];
        for(int num:nums){
            arr[num]++;
            int freq=arr[num];
            if(freq>maxFreq){
                maxFreq=freq;
                total=freq;
            }
            else if(maxFreq==freq){
                total+=freq;
            }
        }
        return total;
    }
}

// 1 Pass
// T.C:O(n)
// S.C:O(101)==O(1)



class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n=nums.length;
        int max=-1;
        int arr[]=new int[101];
        for(int i=0;i<n;i++){
            arr[nums[i]]++;
            if(arr[nums[i]]>max){
                max=arr[nums[i]];
            }
        }
        int cnt=0;
        for(int i=0;i<101;i++){
            if(arr[i]==max){
                cnt+=arr[i];
            }
        }
        return cnt;
    }
}

// T.C:O(n)
// S.C:O(101)==O(1)




class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> mp=new HashMap<>();
        int max=-1;
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
            if(mp.get(num)>max){
                max=mp.get(num);
            }
        }
        int cnt=0;
        for(int i:mp.values()){
            if(i==max){
                cnt++;
            }
        }
        return cnt*max;
    }
}

// T.C:O(n)
// S.C:O(n)
