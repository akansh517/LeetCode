class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> notLost=new ArrayList<>();
        List<Integer> lostOnce=new ArrayList<>();
        Map<Integer,Integer> losers=new HashMap<>();

        for(int match[]:matches){
            int loss=match[1];
            losers.put(loss,losers.getOrDefault(loss,0)+1);
        }

        for(int match[]:matches){
            int winn=match[0];
            int loss=match[1];
            if(!losers.containsKey(winn)){
                notLost.add(winn);
                losers.put(winn,losers.getOrDefault(winn,0)+1);
            }

            if(losers.get(loss)==1){
                lostOnce.add(loss);
            }
        }

        Collections.sort(notLost);
        Collections.sort(lostOnce);

        List<List<Integer>> ans=new ArrayList<>();
        ans.add(notLost);
        ans.add(lostOnce);
        return ans;
    }
}


// T.C:O(nlogn)
// S.C:O(n)




// class Solution {
    
//     public List<List<Integer>> findWinners(int[][] matches) {
//         List<Integer> winner=new ArrayList<>();
//         List<Integer> loser=new ArrayList<>();
//         Map<Integer,Integer> losers=new HashMap<>();

//         Set<Integer> st=new HashSet<>();
//         Set<Integer> st2=new HashSet<>();
//         for(int match[]:matches){
//             int loss=match[1];
//             st.add(loss);
//         }

//         for(int match[]:matches){
//             int winn=match[0];
//             if(!st.contains(winn)){
//                 st2.add(winn);
//             }
//         }

//         for(int val:st2){
//             winner.add(val);
//         }

//         for(int match[]:matches){
//             int loss=match[1];
//             losers.put(loss,losers.getOrDefault(loss,0)+1);
//         }

//         for(int i:losers.keySet()){
//             if(losers.get(i)==1){
//                 loser.add(i);
//             }
//         }

//         Collections.sort(winner);
//         Collections.sort(loser);

//         List<List<Integer>> ans=new ArrayList<>();
//         ans.add(winner);
//         ans.add(loser);
//         return ans;

//     }
// }