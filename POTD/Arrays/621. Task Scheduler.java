class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> mp=new HashMap<>();
        for(char ch:tasks){ //O(n)
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        // We want to finish the process which is most occurring (having highest frequency)
        // so that we don't have to finish in the last with p gaps.
        for(int x:mp.values()){
            pq.offer(x);
        }
        int time=0;

        while(!pq.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            for(int i=1;i<=n+1;i++){
                // Filling first p+1 characters
                if(!pq.isEmpty()){
                    int freq=pq.poll();
                    temp.add(freq-1);//Finishing one instance of each process
                }
            }
            
            for(int freq:temp){ //O(logk) where k=26
                if(freq>0){
                    pq.offer(freq);
                }
            }
            // If all processes are finished
            time += pq.isEmpty()?temp.size():(n + 1); // We finished p+1 tasks above in the loop
        }
        return time;        
    }
}

// T.C:O(nlog26)==O(n)
// S.C:O(26)=O(1)