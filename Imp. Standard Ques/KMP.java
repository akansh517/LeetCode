
class Solution
{
    int m;
    int n;
    
    public int[] computeLPS(String pat){
        int i=1;
        int length=0;
        int LPS[]=new int[m];
        LPS[0]=0;
        while(i<m){
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
    
    public ArrayList<Integer> KMP(String pat, String txt)
    {
        // your code here
        ArrayList<Integer> res=new ArrayList<>();
        m=pat.length();
        n=txt.length();
        int LPS[]=computeLPS(pat);
        int i=0;
        int j=0;
        while(i<n){
            if(txt.charAt(i)==pat.charAt(j)){
                i++;
                j++;
            }
            if(j==m){
                res.add(i-j);   //0 based indexing
        
                // res.add(i-j+1); // 1 based indexing
                // j=LPS[j-1];  finding all occurences by using this 
            }
            else if (i<n && (j==0 || txt.charAt(i)!=pat.charAt(j))){
                if(j!=0){
                    j=LPS[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return res;
    }
}


// T.C:O(m+n) where m=txt.length() and n=pat.length()
// S.C:O(n)