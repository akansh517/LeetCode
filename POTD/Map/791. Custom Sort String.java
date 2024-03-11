class Solution {
    public String customSortString(String order, String s) {
        int freq[]=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        String ans="";

        for(char ch:order.toCharArray()){
            while(freq[ch-'a']>0){
                ans+=ch;
                freq[ch-'a']--;
            }
        }

        for(char ch:s.toCharArray()){
            while(freq[ch-'a']>0){
                ans+=ch;
                freq[ch-'a']--;
            }
        }
        return ans;
    }
}


// T.C:O(n)
// S.C:O(26)




class Solution {
    public String customSortString(String order, String s) {
        Map<Character,Integer> mp=new HashMap<>();
        for(char ch:s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        String ans="";
        for(char ch:order.toCharArray()){
            while(mp.getOrDefault(ch,0)>0){
                ans+=ch;
                mp.put(ch,mp.get(ch)-1);
            }
        }
        // Iterate through freq and append remaining letters
        // This is necessary because some letters may not appear in order
        for(char i:mp.keySet()){
            int cnt=mp.get(i);
            while(cnt>0){
                ans+=i;
                cnt--;
            }
        }
        return ans;
    }
}


// T.C:O(n)
// S.C:O(n)