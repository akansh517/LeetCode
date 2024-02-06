class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,List<String>> bmap=new HashMap<>();
        for(String str:strs){
            HashMap<Character,Integer> fmap=new HashMap<>();
            for(char ch:str.toCharArray()){
                fmap.put(ch,fmap.getOrDefault(ch,0)+1);
            }
            if(!bmap.containsKey(fmap)){
                List<String> list=new ArrayList<>();
                list.add(str);
                bmap.put(fmap,list);
            }
            else{
                List<String> list=bmap.get(fmap);
                list.add(str);
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for(List<String> val:bmap.values()){
            ans.add(val);
        }
        return ans;
    }
}



// T.C:O(m*k*26) where m is length of the strs array 
// S.C:O(m)