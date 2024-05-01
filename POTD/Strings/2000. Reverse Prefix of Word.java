class Solution {
    public String reversePrefix(String word, char ch) {
        char chars[]=word.toCharArray();
        int i=0;
        int j=word.indexOf(ch);
        while(i<j){
            char temp=chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
            i++;
            j--;
        }
        return new String(chars);
    }
}

//T.C : O(n)
//S.C : O(1)




class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index != -1) {
            return new StringBuilder(word.substring(0, index + 1)).reverse().toString() + word.substring(index + 1);
        }
        return word;
    }
}
//Using Library Functions
//T.C : O(n)
//S.C : O(1)




class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb=new StringBuilder();
        int idx=-1;
        for(int i=0;i<word.length();i++){
            char c1=word.charAt(i);
            if(c1==ch){
                idx=i;
                break;
            }
        }
        for(int j=idx;j>=0;j--){
            sb.append(word.charAt(j));
        }
        for(int k=idx+1;k<word.length();k++){
            sb.append(word.charAt(k));
        }
        return sb.toString();
    }
}