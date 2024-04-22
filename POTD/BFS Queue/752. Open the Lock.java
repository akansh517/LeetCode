class Solution {
    public void fillNeighbours(Queue<String> que,StringBuilder curr,Set<String> set){
        for(int i=0;i<4;i++){
            char ch=curr.charAt(i);
            char inc=(ch=='9') ?'0':(char)(ch+1);
            char dec=(ch=='0')?'9':(char)(ch-1);
            curr.setCharAt(i, inc);
            String incStr = curr.toString();

            if(!set.contains(incStr)){
                set.add(incStr);
                que.offer(incStr);
            }
            curr.setCharAt(i, dec);
            String decStr = curr.toString();

            if(!set.contains(decStr)){
                set.add(decStr);
                que.offer(decStr);
            }
            curr.setCharAt(i, ch);
        }
    }
    public int openLock(String[] deadends, String target) {
        Set<String> set=new HashSet<>();
        for(String deadend:deadends){
            set.add(deadend);
        }

        String start="0000";
        if(set.contains(start)){
            return -1;
        }
        int levels=0;
        Queue<String> que=new LinkedList<>();
        que.offer(start);
        
        while(!que.isEmpty()){
            int size=que.size();
            while(size-->0){
                String curr=que.poll();
                if(curr.equals(target)){
                    return levels;
                }
                StringBuilder currBuilder = new StringBuilder(curr);
                fillNeighbours(que,currBuilder,set);
            }
            levels++;
        }
        return -1;
    }
}


//Using BFS
//T.C : We have n = 10 slots in each wheel and we have w = 4 wheels. In worst case we will explore all possible combinations.
//      Total Combinations = O(n^w)
//S.C : In worst case we will store all possible combinations in queue O(n^w)