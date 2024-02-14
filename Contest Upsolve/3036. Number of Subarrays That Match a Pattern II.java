class Solution {

    public int[] solve(String p){ //computing longest prefix suffix
        int i=1;
        int LPS[]=new int[p.length()];
        LPS[0]=0;
        int len=0;
        while(i<p.length()){
            if(p.charAt(i)==p.charAt(len)){
                len++;
                LPS[i]=len;
                i++;
            }
            else{
                if(len>0){
                    len=LPS[len-1];
                }
                else{
                    LPS[i]=0;
                    i++;
                }
            }
        }
        return LPS;
    } 

    public ArrayList<Integer> KMP(String s,String p){
        int LPS[]=solve(p);
        int i=0;
        int j=0;
        int m=s.length();
        int n=p.length();
        ArrayList<Integer> ans=new ArrayList<>();
        while(i<m){
            if(s.charAt(i)==p.charAt(j)){
                i++;
                j++;
            }
            if(j==n){
                ans.add(i-j);
                j=LPS[j-1];
            }
            else if(i<m && s.charAt(i)!=p.charAt(j)){
                if(j!=0){
                    j=LPS[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return ans;
    }

    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        StringBuilder nString=new StringBuilder();
        StringBuilder pString=new StringBuilder();
        int m=pattern.length;
        int n=nums.length;

        for(int i=0;i<m;i++){
            if(pattern[i]==1){
                pString.append('a');
            }
            else if(pattern[i]==0){
                pString.append('s');
            }
            else{
                pString.append('d');
            }
        }

        for(int i=0;i<n-1;i++){
            if(nums[i+1]-nums[i]>0){
                nString.append('a');
            }
            else if(nums[i+1]-nums[i]==0){
                nString.append('s');
            }
            else{
                nString.append('d');
            }
        }
        String s=nString.toString();
        String p=pString.toString();
        System.out.println(s);
        System.out.println(p);
        ArrayList<Integer> kmp=KMP(s,p);
        return kmp.size();
    }
}

// Using KMP Pattern matching algo.
// T.C:O(m+n)
// S.C:O(m+n)
// In best case S.C:O(m)==O(n)===O(2n) i.e the length of the pattern