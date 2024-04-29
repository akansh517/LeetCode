class Solution {
    public int minOperations(int[] nums, int k) {
        int xor=0;
        for(int num:nums){//O(n)
            xor^=num;
        }
        int diff=xor^k;
        return Integer.bitCount(diff);//logarithmic
    }
}
// T.C:O(n)
// S.C:O(1)

class Solution {
    public int minOperations(int[] nums, int k) {
        int xor=0;
        for(int num:nums){
            xor=xor^num;
        }
        
        String str1=Integer.toBinaryString(xor);
        String str2=Integer.toBinaryString(k);
        String sb1="";
        String sb2="";
        for(int i=0;i<32-str1.length();i++){
            sb1+='0';
        }
        for(int i=0;i<str1.length();i++){
            sb1+=str1.charAt(i);
        }

        for(int i=0;i<32-str2.length();i++){
            sb2+='0';
        }
        for(int i=0;i<str2.length();i++){
            sb2+=str2.charAt(i);
        }

        int op=0;
        for(int i=0;i<32;i++){
            if(sb1.charAt(i)!=sb2.charAt(i)){
                op++;
            }
        }
        return op;
    }
}


class Solution {
    public int minOperations(int[] nums, int k) {
        int ans=0;
        for(int bit=0;bit<=20;bit++){
            int xorVal=0;
            for(int num:nums){
                int bitVal=(1<<bit)&num;
                xorVal=xorVal^bitVal;
            }
            int kthbitVal=(1<<bit)&k;
            if(xorVal!=kthbitVal)  ans++;
        }
        return ans;
    }
}

// nums[i]=1e6 so 1e6<=2^20 I have n numbers for which i have to go atmax 20 bits for each number so complexity becomes 2^20*1e5 ==2*1e6
// T.C:O(n*20)=>O(2*1e6) at max
// S.C:O(1)



class Solution {
    public int minOperations(int[] nums, int k) {
        int minops=0;
        for(int num:nums){
            minops=minops^num;
        }
        int var=minops^k;
        int ans=0;
        while(var!=0){
            ans+=var&1;
            var>>=1;
        }
        return ans;
    }
}