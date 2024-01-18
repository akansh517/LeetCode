class Solution {

    public int[] computeLPS(String pat){
        int n=pat.length();
        int length=0;
        int i=1;
        int LPS[]=new int[n];
        LPS[0]=0;
        while(i<n){
            if(pat.charAt(i)==pat.charAt(length)){
                length++;
                LPS[i]=length;
                i++;
            }
            else{
                if(length!=0){
                    length=LPS[length-1];
                }
                else{
                    LPS[i]=0;
                    i++;
                }
            }
        }
        return LPS;
    }


    public List<Integer> KMP(String txt,String pat){  
        int i=0;
        int j=0;
        int LPS[]=computeLPS(pat);
        List<Integer> ans=new ArrayList<>();
        while(i<txt.length()){
            if(txt.charAt(i)==pat.charAt(j)){
                i++;
                j++;
            }
            if(j==pat.length()){
                ans.add(i-j);
                j=LPS[j-1];
            }
            else if(i<txt.length() && ( j==0 || txt.charAt(i)!=pat.charAt(j)) ){
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

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> i_indices=KMP(s,a); //O(a.length()+s.length())
        List<Integer> j_indices=KMP(s,b);   //O(b.length()+s.length())
        List<Integer> res=new ArrayList<>();
        for(int m=0;m<i_indices.size();m++){    //2 nested for loop 
            for(int n=0;n<j_indices.size();n++){
                int val=i_indices.get(m)-j_indices.get(n);
                if(Math.abs(val)<=k){
                    res.add(i_indices.get(m));
                    break;
                }
            }
        }
        return res;
    }
}

// Using KMP algo 
// T.C: O(m*n) where m=i_indices.size() & n=j_indices.size()
// S.C:O(m+n)