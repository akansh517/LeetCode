class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n=deck.length;
        int result[]=new int[n];
        Arrays.sort(deck);
        int i=0;
        int j=0;
        boolean skip=false;
        while(i<n){
            if(result[j]==0){
                if(skip==false){
                    result[j]=deck[i];
                    i++;
                }
                skip=!skip;
            }
            j=(j+1)%n;
        }
        return result;
    }
}

//T.C : O(nlogn)
//S.C : O(1)