class Solution {
    public String minimizeStringValue(String s) {
        int freq[]=new int[26];
        for(char ch:s.toCharArray()){
            if(ch!='?'){
                freq[ch-'a']++;
            }
        }

        List<Character> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<s.length();i++){ //O(n)
            char ch=s.charAt(i);
            if(ch=='?'){
                int minIndex=-1;
                int min=Integer.MAX_VALUE;
                for(int j=freq.length-1;j>=0;j--){ //O(26)
                    if(freq[j]<=min){
                        min=freq[j];
                        minIndex=j;
                    }
                }
                char minChar=(char)(minIndex+'a');
                list.add(minChar);
                freq[minIndex]++;
            }
        }
        // Sorting the list of characters, in the worst case, can take O(nlogn) time if all characters in s are ‘?’.
        Collections.sort(list);//Sort all characters according to lexicographical order
        int a=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='?'){
                sb.append(s.charAt(i));
            }
            else{
                sb.append(list.get(a++));
            }
        }
        return sb.toString();
    }
}

// T.C: O(n log n)
// S.C: O(n)The list can potentially store every character in s if all are ‘?’,resulting in
// O(n) space


