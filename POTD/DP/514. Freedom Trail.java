class Solution {
    int dp[][];
    public int countSteps(int rIndex,int i,int length){
        int distance=Math.abs(i-rIndex);
        int wrapAround=length-distance;
        int steps=Math.min(distance,wrapAround);
        return steps;
    }
    public int solve(int rIndex,int kIndex,String ring, String key){
        if(kIndex>=key.length()){
            return 0;
        }
        if(dp[rIndex][kIndex]!=-1){
            return dp[rIndex][kIndex];
        }
        int result=Integer.MAX_VALUE;
        for(int i=0;i<ring.length();i++){//I am using for loop here bcz i have to check where the character is present inside the ring that is inside the key 
            if(ring.charAt(i)==key.charAt(kIndex)){
                int steps=1+countSteps(rIndex,i,ring.length());
                int totalSteps=steps+solve(i,kIndex+1,ring,key);
                result=Math.min(result,totalSteps);
            }
        }
        return dp[rIndex][kIndex]=result;
    }
    public int findRotateSteps(String ring, String key) {
        dp=new int[ring.length()][key.length()];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,ring,key);
    }
}


// For every character inside the key ,we are trying for each position inside the ring.For e.g:-if key has "a" and ring has  "aaaaaa" then it will try for each position inside the ring.O(n^m), where n is the length of the ring string and m is the length of the key string.the algorithm will explore all possible positions in the ring string recursively, without reusing any previous resultsExponential


// With memo: we will maximum visit m*n states and while visiting these states we are also running 1 for loop that will cost O(n) so overall T.C:O(m*n^2)
//S.C : O(101*101) ~ O(1)
