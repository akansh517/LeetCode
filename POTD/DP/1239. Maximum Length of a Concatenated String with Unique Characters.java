class Solution {
    int n;
    public boolean isDuplicate(String s1,String s2){
        int freq[]=new int[26];
        for(char ch:s1.toCharArray()){
            if(freq[ch-'a']>0){
                return true;
            }
            freq[ch-'a']++;
        }

        for(char ch:s2.toCharArray()){
            if(freq[ch-'a']>0){
                return true;
            }
        }
        return false;
    }

    public int solve(List<String> arr,String temp,int i){
        if(i>=n){ 
            return temp.length();
        }
        int include=0;
        int exclude=0;
        if(isDuplicate(arr.get(i),temp)){  //exclude only
            exclude=solve(arr,temp,i+1);
        }
        else{   //2 options -include,exclude
            exclude=solve(arr,temp,i+1);
            include=solve(arr,temp+arr.get(i),i+1);
        }
        return Math.max(include,exclude);
    }

    public int maxLength(List<String> arr) {
        n=arr.size();
        String temp="";
        int i=0;
        return solve(arr,temp,i);
    }
}


// T.C:O(n*2^n)
// S.C:O(n)

// When we drawing the tree diagram then if we don't see any repeating subproblem or states then in that case we don't need to apply memoization similarly in this case