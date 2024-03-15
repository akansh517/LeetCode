
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        ans[0]=1;
        for(int i=1;i<n;i++){
            ans[i]=ans[i-1]*nums[i-1];
        }

        int rightProd=1;
        for(int i=n-1;i>=0;i--){
            ans[i]=ans[i]*rightProd;
            rightProd*=nums[i];
        }
        return ans;
    }
}


// T.C:O(n)
// S.C:O(1) 


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        int prod=1;
        int countZeros=0;

        for(int num:nums){
            prod*=num;
            if(num==0){
                countZeros++;
            }
        }

        int prodWithoutZero=1;
        for(int num:nums){
            if(num!=0){
                prodWithoutZero*=num;
            }
        }


        for(int i=0;i<n;i++){
            if(nums[i]==0){
                if(countZeros>1){
                    ans[i]=0;
                }
                else{
                    ans[i]=prodWithoutZero;
                }
            }
            else{
                if(countZeros>0){
                    ans[i]=0;
                }
                else{
                    ans[i]=prodWithoutZero/nums[i];
                }
            }
        }
        return ans;
    }
}
// (Using Division)
// T.C: O(n)
// S.C: O(1)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        int leftProd[]=new int[n];
        int rightProd[]=new int[n];
        leftProd[0]=1;
        rightProd[n-1]=1;
        for(int i=1;i<n;i++){
            leftProd[i]=leftProd[i-1]*nums[i-1];
        }

        for(int i=n-2;i>=0;i--){
            rightProd[i]=rightProd[i+1]*nums[i+1];
        }

        for(int i=0;i<n;i++){
            ans[i]=leftProd[i]*rightProd[i];
        }
        return ans;
    }
}


// T.C:O(n)
// S.C:O(2n) due to the leftProd and rightProd


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        int k=0;
        for(int i=0;i<n;i++){
            int prod=1;
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                else{
                    prod*=nums[j];
                }
            }
            ans[k++]=prod;
        }
        return ans;
    }
}

// T.L.E
// T.C:O(n^2)
// S.C:O(1)