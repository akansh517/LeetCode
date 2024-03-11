class Solution {
    public String[] shortestSubstrings(String[] arr) {
        HashMap<String,Integer> mp=new HashMap<>(); //O(n^2) to store substr
        for(String str:arr){//O(n)
            Set<String> set=new HashSet<>();
            for(int i=0;i<str.length();i++){//O(n^2)
                for(int j=i+1;j<=str.length();j++){
                    String temp=str.substring(i,j);
                    if(!set.contains(temp)){//O(n)
                        mp.put(temp,mp.getOrDefault(temp,0)+1);
                        set.add(temp);
                    }
                }
            }
        }
        System.out.println(mp);
     
        List<String> result=new ArrayList<>();
        for(String str:arr){
            String shortest="";
            for(int i=0;i<str.length();i++){
                for(int j=i+1;j<=str.length();j++){
                    String temp=str.substring(i,j);
                    if(mp.get(temp)==1 && (shortest.equals("") || shortest.length()>temp.length() || 
                    (shortest.length()==temp.length() && temp.compareTo(shortest)<0))){
                        shortest=temp;
                    }
                }
            }
            result.add(shortest);
        }

        return result.toArray(new String[0]);
    }
}

//Only one smart move is to precompute the substrings so that you don't have to
//check for same substring again and again
//T.C : ~O(n^4)
//S.C : O(n^3) storing all unique substrings in seen 
// (In worst case we will have n^2 substrings from each string (suppose of length n)
//  and let's we have n string in total