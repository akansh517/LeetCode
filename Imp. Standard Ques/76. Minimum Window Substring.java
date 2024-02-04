class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        if(t.length()>n){
            return "";
        }

        Map<Character,Integer> mp=new HashMap<>();
        for(char ch:t.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }

        int i=0;
        int j=0;
        int minWindowSize=Integer.MAX_VALUE;
        int minStart=0;
        int requiredCount=t.length();

        while(j<n){
            char ch_j=s.charAt(j);
            if(mp.containsKey(ch_j) && mp.get(ch_j)>0){
                requiredCount--;
            }
            mp.put(ch_j,mp.getOrDefault(ch_j,0)-1);

            while(requiredCount==0){    //start shrinking the window
                if(minWindowSize>j-i+1){
                    minWindowSize=j-i+1;
                    minStart=i;
                }
                char ch_i=s.charAt(i);
                mp.put(ch_i,mp.getOrDefault(ch_i,0)+1);
                if(mp.containsKey(ch_i) & mp.get(ch_i)>0){
                    requiredCount++;
                }
                i++;
            }
            j++;
        }
        return minWindowSize==Integer.MAX_VALUE?"":s.substring(minStart,minStart+minWindowSize);
    }
}

// Approach Sliding Winodow 
// T.C:O(n) where n is the length pf the string s 
// S.C:O(m) where m is the length of the string t .we use additional space for the map from string t







// class Solution {
//     public boolean isPossible(String temp,String t){
//         int arr[]=new int[125];
//         for(char ch:temp.toCharArray()){
//             arr[ch-'0']++;
//         }

//         int arr2[]=new int[125];
//         for(char ch:t.toCharArray()){
//             arr2[ch-'0']++;
//         }

//         for(int i=0;i<125;i++){
//             if(arr2[i]<=arr[i]){
//                 continue;
//             }
//             else{
//                 return false;
//             }
//         }
//         return true;

//     }

//     public String minWindow(String s, String t) {
//         int n=s.length();
//         if(t.length()>s.length()){
//             return "";
//         }

//         // String ans="";
//         List<String> list=new ArrayList<>();
//         int min=s.length();
//         for(int i=0;i<n;i++){
//             for(int j=i;j<=n;j++){
//                 String temp=s.substring(i,j);
//                 if(isPossible(temp,t)){
//                     min=Math.min(min,temp.length());
//                     list.add(temp);
//                 }
//             }
//         }

//         for(int i=0;i<list.size();i++){
//             String res=list.get(i);
//             if(res.length()==min){
//                 return res;
//             }
//         }
//         return "";
//     }
// }    
// Brute Force T.L.E 
// T.C:O(n^2*(125))