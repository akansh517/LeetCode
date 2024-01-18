class Solution {
    public int[] computeLPS(String pat){
        int i=1;
        int length=0;// Length of the previous longest prefix & suffix
        int LPS[]=new int[pat.length()];
        LPS[0]=0;// Because there is no proper suffix and prefix of pattern[0..0]
        while(i<pat.length()){
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
        int i=0; //txt index
        int j=0; //pat index
        List<Integer> res=new ArrayList<>();
        // Create an LPS array to store the longest proper prefix which is also a suffix
        // lps[i] = the longest proper prefix of pat[0..i] which is also a suffix of pat[0..i].
        int LPS[]=computeLPS(pat);
        while(i<txt.length()){
            if(txt.charAt(i)==pat.charAt(j)){
                i++;
                j++;
            }
            if(j==pat.length()){
                res.add(i-j);// Pattern found at index i-j 
                j=LPS[j-1];
            }
            else if(i<txt.length() && (j==0 || txt.charAt(i)!=pat.charAt(j))){
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
    // Finding lower Bound of an element in a sorted list
    public int lowerBound(List<Integer> list,int target){
        int left=0;
        int right=list.size()-1;
        int result=list.size();
        while(left<=right){
            int mid=left+(right-left)/2;
            if(list.get(mid)>=target){
                result=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return result;
    }

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int n=s.length();
        List<Integer> i_indices=KMP(s,a);
        List<Integer> j_indices=KMP(s,b);
        List<Integer> ans=new ArrayList<>();
        for(int i: i_indices){
            /*
             * For every index i where 'a' was found in 's' I will see if we find any index
             * j in the range i-k and i+k
             */
            int left_limit=Math.max(0,i-k);// To avoid out of bound -> I used max(0, i-k)
            int right_limit=Math.min(i+k,n-1);// To avoid out of bound -> I used min(n-1, i+k)
            int lowerBoundIndex=lowerBound(j_indices,left_limit);
            if(lowerBoundIndex<j_indices.size() && j_indices.get(lowerBoundIndex)<=right_limit){
                ans.add(i);
            }
        }
        return ans;
    }
}


// KMP Variation

//T.C : O((m+n) + nlogn) --> O(m+n) for KMP, O(nlogn) for iterating over i_indices and searching the lowerbound
//S.C : ~ O(n)