class Solution {
    List<String> result=new ArrayList<>();
    public void solve(int i,String currSentence,String s,List<String> wordDict){
        if(i>=s.length()){
            result.add(currSentence.trim());
            return;
        }
        for(int j=i;j<s.length();j++){
            String tempWord=s.substring(i,j+1);
            if(wordDict.contains(tempWord)){
                if(!tempWord.isEmpty()){
                    tempWord+=" ";
                }
                String tempSentence=currSentence;
                currSentence+=tempWord;//do something
                solve(j+1,currSentence,s,wordDict);//explore
                currSentence=tempSentence;//undo
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        String currSentence="";
        solve(0,currSentence,s,wordDict);
        return result;
    }
}


//  (Using simple backtracking)
//T.C : O(2^n)
//S.C : max depth of recursion is n (length of string s). You can say O(n) . You also have to store those sentences which is O(2^n)

class Solution {
    Map<String,List<String>> mem;
    public List<String> solve(String s, List<String> wordDict){
        if(s.isEmpty()){
            return Arrays.asList("");
        }
        if(mem.containsKey(s)){
            return mem.get(s);
        }
        List<String> res=new ArrayList<>();
        for(int l=1;l<=s.length();l++){
            String currWord=s.substring(0,l);
            if(wordDict.contains(currWord)){
                String remainWord=s.substring(l);
                List<String> remainSentence=solve(remainWord,wordDict);
                for(String w:remainSentence){
                    String toAdd=currWord+(w.isEmpty()?"":" ")+w;
                    res.add(toAdd);
                }
            }
        }
        mem.put(s,res);
        return res;

    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        mem=new HashMap<>();
        return solve(s,wordDict);
    }
}
//T.C : O(2^n)
//S.C : max depth of recursion is n (length of string s). You can say O(n) . You also have to store those sentences which is O(2^n