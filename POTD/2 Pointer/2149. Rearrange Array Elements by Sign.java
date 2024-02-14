class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        int posIndex=0;
        int negIndex=1;
        for(int num:nums){
            if(num>0){
                ans[posIndex]=num;
                posIndex+=2;
            }
            else{
                ans[negIndex]=num;
                negIndex+=2;
            }
        }
        return ans;
    }
}
// T.C:O(n) traversing the nums once
// S.C:O(n) due to the ans array




class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        int half=n/2;
        int pos[]=new int[half];
        int neg[]=new int[half];

        int x=0;
        int y=0;
        for(int num:nums){
            if(num>0){
                pos[x]=num;
                x++;
            }
            else{
                neg[y]=num;
                y++;
            }
        }

        int m=0;
        int k=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                ans[i]=pos[m];
                m++;
            }
            else{
                ans[i]=neg[k];
                k++;
            }
        }
        return ans;
    }
}


// T.C:O(n)
// S.C:O(n/2+n/2)==O(n) due to the 2 half arrays