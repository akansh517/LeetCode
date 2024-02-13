class Solution {
    public boolean isPalindrome(String word){
        int m=word.length();
        for(int i=0;i<m/2;i++){
            if(word.charAt(i)!=word.charAt(m-i-1)){
                return false;
            }
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        int n=words.length;
        for(String word:words){
            if(isPalindrome(word)){
                return word;
            }
        }
        return "";
    }
}


// T.C:O(m*n) m = number of words, n = max length length of words
// S.C:O(1)



class Solution {
    public String firstPalindrome(String[] words) {
        for(String word:words){
            String reversed=new StringBuilder(word).reverse().toString();
            if(word.equals(reversed)){
                return word;
            }
        }
        return "";
    }
}
//T.C : O(m*n) - m = number of words, n = max length length of words
//S.C : O(n) - Creating a reversed string
