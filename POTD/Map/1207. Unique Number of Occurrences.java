class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int ans[]=new int[2001];
        for(int x:arr){
            ans[x+1000]++;
        }
        Arrays.sort(ans);
        for(int i=1;i<2001;i++){
            if(ans[i] != 0 && ans[i]==ans[i-1]){
                return false;
            }
        }
        return true;
    }
}

//T.C : O(nlogn)
//S.C : O(1)





// class Solution {
//     public boolean uniqueOccurrences(int[] arr) {
//         Map<Integer,Integer> mp=new HashMap<>();
//         for(int num:arr){
//             mp.put(num,mp.getOrDefault(num,0)+1);
//         }
//         Set<Integer> set=new HashSet<>();
//         for(int val:mp.values()){
//             if(set.contains(val)){
//                 return false;
//             }
//             set.add(val);
//         }
//         return true;
//     }
// }

// Simple using hash map and set
//T.C : O(n)
//S.C : O(n)