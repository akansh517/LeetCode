class Solution {
    public int tribonacci(int n) {
        if(n==0)    return 0;
        if(n==1 || n==2)    return 1;
        int a=0;
        int b=1;
        int c=1;
        int d=0;
        for(int i=3;i<=n;i++){
            d=a+b+c;
            a=b;
            b=c;
            c=d;
        }
        return d;
    }
}
// T.C:O(n)
// S.C:O(1)


class Solution {
    int dp[];
    public int find(int n){
        if(n<=0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int a=find(n-1);
        int b=find(n-2);
        int c=find(n-3);
        return dp[n]=a+b+c;
    }
    public int tribonacci(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return find(n);
    }
}

//  (Recursion + Memoization)
// T.C: Without Memoization - O(3^n) and with Memoization - O(n)
// S.C: O(n) (But size of t is 38 which is constant hence O(1))


class Solution {
    public int tribonacci(int n) {
        if(n<=0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        int arr[]=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        arr[2]=1;
        for(int i=3;i<n+1;i++){
            arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
        }
        return arr[n];
    }
}