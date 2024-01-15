// class Solution {
//     public boolean closeStrings(String word1, String word2) {
//         int freq1[]=new int[26];
//         int freq2[]=new int[26];
//         for(char ch:word1.toCharArray()){
//             freq1[ch-'a']++;
//         }
//         for(char ch:word2.toCharArray()){
//             freq2[ch-'a']++;
//         }

//         for(int i=0;i<26;i++){
//             if(freq1[i]!=0 && freq2[i]==0){
//                 return false;
//             }
//         }

//         Arrays.sort(freq1);
//         Arrays.sort(freq2);

//         for(int i=0;i<26;i++){
//             if(freq1[i]!=freq2[i]){
//                 return false;
//             }
//         }
//         return true;


//     }
// }





class Solution {
    public boolean closeStrings(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        if(m!=n)    return false;
        int freq1[]=new int[26];
        int freq2[]=new int[26];
        for(int i=0;i<m;i++){
            char ch1=word1.charAt(i);
            char ch2=word2.charAt(i);
            freq1[ch1-'a']++;
            freq2[ch2-'a']++;
        }

        for(int i=0;i<26;i++){

            // The character which is in word1 should also be present in the word2

            // if(freq1[i]!=0 && freq2[i]==0){
            //     return false;
            // }
            // or
            if( (freq1[i]!=0 && freq2[i]!=0)  || (freq1[i]==0 && freq2[i]==0) ){
                continue;
            }
            return false;
        }
        // Match the frequency so to match the freq. we will sort both the arrays
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1,freq2);
        // for(int i=0;i<26;i++){
        //     if(freq1[i]!=freq2[i]){
        //         return false;
        //     }
        // }
        // return true;

    }
}


//T.C : O(nlogn)due to the sorting but it will not take so much time for sort due to 26 sized array   
//S.C : O(26) ~ O(1) due to the 26 sized array
