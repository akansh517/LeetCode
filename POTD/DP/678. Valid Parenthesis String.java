class Solution {
    int n;
    int dp[][];
    public boolean solve(int idx,int open,String s){
        boolean isValid=false;
        if(idx==n){
            return (open==0);
        }
        if(dp[idx][open]!=-1){
            return dp[idx][open]==1;
        }
        
        if(s.charAt(idx)=='*'){
            isValid|=solve(idx+1,open+1,s);
        if(open>0){
            isValid|=solve(idx+1,open-1,s);
        }
        isValid|=solve(idx+1,open,s);
        }
        else{
            if(s.charAt(idx)=='('){
                isValid|=solve(idx+1,open+1,s);
            }
            else if(open>0){
                isValid|=solve(idx+1,open-1,s);
            }
        }
        dp[idx][open]=isValid?1:0;
        return isValid;
        
    } 
    public boolean checkValidString(String s) {
        n=s.length();
        dp=new int[n+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,s);
    }
}

//T.C : O(n*n)
//S.C : O(n*n)


