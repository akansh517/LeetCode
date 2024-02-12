class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int wordSize[]=new int[words.length];
        int freqChar[]=new int[26];
        for(int i=0;i<words.length;i++){
            wordSize[i]=words[i].length();
            for(int j=0;j<words[i].length();j++){
                freqChar[words[i].charAt(j)-'a']++;
            }
        }
        Arrays.sort(wordSize);
        int even=0;
        int odd=0;
        for(int i=0;i<26;i++){
            if(freqChar[i]%2==1){
                odd++;
            }
            even+=freqChar[i]/2;
        }

        int ans=0;
        for(int i=0;i<wordSize.length;i++){
            if(wordSize[i]%2==1){//if odd length 
                if(odd!=0){ //if i have odd then i will place it in the middle
                    odd--;
                }
                else{   //i have to borrow from even and transfer to the odd so by deducting
                    even--; //2 odd elements will be deducted and 1 odd element will be placed
                    odd++; //odd+=2 but i can place only 1 odd so odd-=1
                }
            }
            if(even<wordSize[i]/2)  break;//if even pairs are less than length then break
            even-=wordSize[i]/2;
            ans++;  //increasing the count 
        }
        return ans;
    }
}


// Intuition  
// L1- Always place the odd freq char in middle when length is odd 
// L2- Always fill smaller length first bcz we want max no. of palindromes and not max.lenght pal.


// Store the characters of all the string chars in map or array size of 26 bcz we 
// have smaller case letters  
// there matter is even and odd count 

// Sort the size wordSize of words in increasing order 
// Store all the freq. of all chars of words 
// even count will be count by 2 bcz i want even count 
// and odd is nothing but odd element count odd+=oddelementCount freqChar[i]%2
// even is even pair count even+=freqChar[i]/2 

// if my wordSize[i] length is odd and also i have oddCount then i will grab that odd count
// and place in the middle but if my length is odd but i don't have odd count then i will borrow
// from even and transfer to odd and place the odd in the middle of the wordSize 


// T.C:O(nlogn + n*m)where n is the words.length and m is the words[i].length
// sorting+    visiting all the chars to know the freq of all chars

// S.C:O(n+26)
// array which is storing words length and 26 sized array which will behave as a map and count
// frequency