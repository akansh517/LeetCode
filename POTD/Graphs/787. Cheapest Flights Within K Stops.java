class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int distance[]=new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        Map<Integer,List<int[]>> adj=new HashMap<>();
        // O(E) while forming adjacency list 
        for(int[] flight:flights){
            int u=flight[0];
            int v=flight[1];
            int cost=flight[2];
            adj.computeIfAbsent(u,key->new ArrayList<>()).add(new int[]{v,cost});
        }

        // O(E*n) bcz we can visit each node n-1 times to reach to the destination
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{src,0});
        int steps=0;
        while(!queue.isEmpty() && steps<=k){
            int size=queue.size();
            while(size-->0){
                int current[]=queue.poll();
                int u=current[0];
                int d=current[1];
                List<int[]> neighbours=adj.getOrDefault(u,Collections.emptyList());
                for(int neighbour[]:neighbours){
                    int v=neighbour[0];
                    int cost=neighbour[1];
                    if(distance[v]>d+cost){
                        distance[v]=d+cost;
                        queue.offer(new int[]{v,d+cost});
                    }
                }
            } //after the completion of 1 level we are increasing the steps
            steps++;
        }
        return distance[dst]==Integer.MAX_VALUE?-1:distance[dst];
    }
}


// we are not marking visited to any node bcz we can visit the same node or edge multiple times
// in the worst case we can travel the each node n-1 times to reach to the destination 
// No. of edges =E
// E*n times in Worst case

// BFS traversal of Graph
//T.C : O(V+E) 
//S.C : O(V+E)