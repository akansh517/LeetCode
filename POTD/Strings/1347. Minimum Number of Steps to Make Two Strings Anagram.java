// class Solution {
//     public int minSteps(String s, String t) {
//         int freq1[]=new int[26];
//         for(char ch:s.toCharArray()){
//             freq1[ch-'a']++;
//         }

//         int freq2[]=new int[26];
//         for(char ch:t.toCharArray()){
//             freq2[ch-'a']++;
//         }

//         int ans=0;
//         for(int i=0;i<26;i++){
//             if(freq1[i]>freq2[i]){
//                 ans+=freq1[i]-freq2[i];
//             }
//         }
//         return ans;
//     }
// }


// T.C:O(n)
// S.C:O(26)==O(1) due to the lowercase english letters






// class Solution {
//     public int minSteps(String s, String t) {
//         int freq1[]=new int[26];
//         int freq2[]=new int[26];
//         int n=s.length();
//         for(int i=0;i<n;i++){
//             freq1[s.charAt(i)-'a']++;
//             freq2[t.charAt(i)-'a']++;
//         }
//         int ans=0;
//         for(int i=0;i<26;i++){
//             if(freq1[i]>freq2[i]){
//                 ans+=freq1[i]-freq2[i];
//             }
//         }
//         return ans;
//     }
// }

// 2 counter solution
// T.C:O(n)
// S.C:O(26)==O(1) due to the lowercase english letters







class Solution {
    public int minSteps(String s, String t) {
        int freq[]=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++){
            freq[t.charAt(i)-'a']++;
            freq[s.charAt(i)-'a']--;
        }
        
        int ans=0;
        for(int i=0;i<26;i++){
            ans+=Math.max(0,freq[i]);
        }
        return ans;
    }
}


//Using 1 counter
//T.C : O(n)
//S.C : O(26) ~ O(1)