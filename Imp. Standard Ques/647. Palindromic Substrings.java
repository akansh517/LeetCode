class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean dp[][]=new boolean[n+1][n+1];
        //dp[i][j] = true : s[i:j] is a substring where i and j are inclusive indices
        int count=0;
        for(int l=1;l<=n;l++){
            for(int i=0;i+l<=n;i++){
                int j=i+l-1;
                if(i==j){//Single characters are palindrome
                    dp[i][j]=true;
                }
                else if(i+1==j){ //Strings of 2 Length
                    dp[i][j]=(s.charAt(i)==s.charAt(j));
                }
                else{  //Generic i.e greater than 2 length
                    dp[i][j]=(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]);
                }
                if(dp[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}

// Pattern for solving many ques like palindromic substrings,count odd/even length pal.,
// find largest pal. substring, find longest pal. subsequence
//T.C : O(n^2)
//S.C : O(n^2)





class Solution {
    int count=0;
    public void check(String s,int i,int j,int n){
        while(i>=0 && j<n && s.charAt(i)==s.charAt(j)){
            count++;
            i--;// expanding from center
            j++;// expanding from center
        }
    }
    public int countSubstrings(String s) {
        int n=s.length();
        /*
         * Every single character in the string is a center for possible odd-length
         * palindromes: check(s, i, i); Every pair of consecutive characters in the
         * string is a center for possible even-length palindromes: check(s, i, i+1);
         */
        for(int i=0;i<n;i++){
            check(s,i,i,n);
            check(s,i,i+1,n);
        }
        return count;
    }
}

// Most optimal solution by using palindrome even/odd property 
// T.C : O(n^2)
// S.C : O(1)




// class Solution {
//     int dp[][];
//     public boolean isPalindrome(String s,int i,int j){ //Every subproblem is being computed only once
//         if(i>=j){                                  // and after that,  it's being reused
//             return true;
//         }

//         if(dp[i][j]!=-1){
//             return dp[i][j]==1;
//         }

//         if(s.charAt(i)==s.charAt(j)){
//             boolean val=isPalindrome(s,i+1,j-1);
//             if(val==true){
//                 dp[i][j]=1;
//             }
//             else{
//                 dp[i][j]=0;
//             }
//             return val;
//         }
//         dp[i][j]=0; 
//         return false;       
//     }

//     public int countSubstrings(String s) {
//         int n=s.length();
//         dp=new int[n+1][n+1];
//         for(int row[]:dp){
//             Arrays.fill(row,-1);
//         }
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