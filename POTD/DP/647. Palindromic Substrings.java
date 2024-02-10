class Solution {
    int dp[][];
    public boolean isPalindrome(String s,int i,int j){ //Every subproblem is being computed only once
        if(i>=j){                                  // and after that,  it's being reused
            return true;
        }

        if(dp[i][j]!=-1){
            return dp[i][j]==1;
        }

        if(s.charAt(i)==s.charAt(j)){
            boolean val=isPalindrome(s,i+1,j-1);
            if(val==true){
                dp[i][j]=1;
            }
            else{
                dp[i][j]=0;
            }
            return val;
        }
        dp[i][j]=0; 
        return false;       
    }

    public int countSubstrings(String s) {
        int n=s.length();
        dp=new int[n+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

// T.C : O(n^2) - Every subproblem is being computed only once and after that, it's being reused
// S.C : O(n^2)




// class Solution {
//     public boolean isPalindrome(String s,int i,int j){
//         if(i>j){
//             return true;
//         }

//         if(s.charAt(i)==s.charAt(j)){
//             return isPalindrome(s,i+1,j-1);
//         }
//         return false;        
//     }

//     public int countSubstrings(String s) {
//         int n=s.length();
//         int cnt=0;
//         for(int i=0;i<n;i++){
//             for(int j=i;j<n;j++){
//                 if(isPalindrome(s,i,j)){
//                     cnt++;
//                 }
//             }
//         }
//         return cnt;
//     }
// }


// class Solution {
//     public boolean isPalindrome(String s){
//         int n=s.length();
//         for(int i=0;i<n/2;i++){
//             if(s.charAt(i)!=s.charAt(n-i-1)){
//                 return false;
//             }
//         }
//         return true;
//     }
    
//     public int countSubstrings(String s) {
//         int n=s.length();
//         int cnt=0;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<=n;j++){
//                 String temp=s.substring(i,j);
//                 if(isPalindrome(temp)){
//                     cnt++;
//                 }
//             }
//         }
//         return cnt;
//     }
// }

// T.C:O(n^3)
// S.C:O(1)