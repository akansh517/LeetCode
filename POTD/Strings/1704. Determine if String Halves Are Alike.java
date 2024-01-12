class Solution {
    public boolean isVowel(char ch){
        return ch=='a'|| ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U';
    }

    public boolean halvesAreAlike(String s) {
        int n=s.length();
        int mid=s.length()/2;
        int i=0;
        int j=mid;
        int cnt1=0;
        int cnt2=0;
        while(i<mid && j<n){
            if(isVowel(s.charAt(i)))    cnt1++;
            if(isVowel(s.charAt(j)))    cnt2++;
            i++;
            j++;
        }
        return cnt1==cnt2;
    }
}

//T.C : O(n)
//S.C : O(1)




// class Solution {
//     public int isVowel(String str){
//         int vowels=0;
//         for(char ch:str.toCharArray()){
//             if(ch=='a' || ch=='e' || ch=='o' || ch=='i' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
//                 vowels++;
//             }
//         }
//         return vowels;
//     }

//     public boolean halvesAreAlike(String s) {
//         int n=s.length();
//         int mid=s.length()/2;
//         String firstHalf=s.substring(0,mid);
//         String secondHalf=s.substring(mid,n);
//         if(isVowel(firstHalf)==isVowel(secondHalf)){
//             return true;
//         }
//         return false;
//     }
// }


// T.C:O(n/2+n/2)==O(n)
// S.C:O(1)