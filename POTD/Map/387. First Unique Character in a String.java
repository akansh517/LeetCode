class Solution {
    public int firstUniqChar(String s) {
        int freq[]=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(freq[ch-'a']==1){
                return i;
            }
        }
        return -1;
    }
}

// T.C:O(n)
// S.C:O(1) == 26 lowercase english alphabets 



// class Solution {
//     public int firstUniqChar(String s) {
//         Map<Character,Integer> mp=new HashMap<>();
//         for(char ch:s.toCharArray()){
//             mp.put(ch,mp.getOrDefault(ch,0)+1);
//         }

//         for(int i=0;i<s.length();i++){
//             if(mp.get(s.charAt(i))==1){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }

// T.C:O(n)
// S.C:O(1) == 26 lowercase english alphabets 

