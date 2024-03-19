class Solution {
    public int minimumDeletions(String word, int k) {
        int freq[]=new int[26];
        for(char ch:word.toCharArray()){//O(n) to populate frequency in freq array
            freq[ch-'a']++;
        }
        int result=word.length();
        for(int i=0;i<26;i++){ //O(26)
            int deletions=0;
            int freq_i=freq[i];
            for(int j=0;j<26;j++){  //O(26)
                if(i==j){
                    continue;
                }    
                if(freq[j]<freq[i]){
                    deletions+=freq[j];
                }
                else if(Math.abs(freq[j]-freq[i])>k){
                    deletions+=Math.abs(freq[j]-freq[i]-k);
                }
            }
            result=Math.min(result,deletions);
        }
        return result;
    }
}


// T.C:O(n+26*26)
// S.C:O(26)==O(1)



// Slight optimization with the help of pruning 

class Solution {
    public int minimumDeletions(String word, int k) {
        int freq[]=new int[26];
        for(char ch:word.toCharArray()){//O(n) to populate frequency in freq array
            freq[ch-'a']++;
        }
        Arrays.sort(freq);//O(26log26)
        int result=word.length();
        int cumulative_deletions=0;//storing all the small freq elements which are smaller than choosen min small element
        for(int i=0;i<26;i++){ //O(26)                         
            int freq_i=freq[i];
            int deletions=cumulative_deletions;//deletions taken to find deletion for j = 25 to j > i
            for(int j=25;j>i;j--){  //O(26)    
                if(freq[j]-freq[i]<=k){
                    break;  //Pruning part and now we are not moving our j to the back again
                }   // with the help of sorting and stop at some certain point when condn meets
                else if(freq[j]-freq[i]>k){
                    deletions+=(freq[j]-freq[i]-k);
                }
            }
            result=Math.min(result,deletions);
            cumulative_deletions+=freq_i;
        }
        return result;
    }
}


// T.C:O(n+ 26*26 + 26log26)
// S.C:O(26)==O(1)
