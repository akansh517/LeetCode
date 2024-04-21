class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
        boolean visited[]=new boolean[n];
        Queue<Integer> que=new LinkedList<>();
        que.offer(source);
        visited[source]=true;
        while(!que.isEmpty()){
            int node=que.poll();
            if(node==destination){
                return true;
            }
            for(int it:adj.getOrDefault(node,new ArrayList<>())){
                if(it==destination){
                    return true;
                }
                if(!visited[it]){
                    que.offer(it);
                    visited[it]=true;
                }
            }
        }
        return false;
    }
}
// Using BFS 
// T.C:O(V+E)
// S.C:O(V+E)



class Solution {
    public boolean check(Map<Integer,List<Integer>> adj,int node,int D,boolean visited[]){
        if(node==D)    return true;
        if(visited[node]==true){
            return false;
        }
        visited[node]=true;
        for(int it:adj.getOrDefault(node,new ArrayList<>())){
            if(check(adj,it,D,visited)==true){
                return true;
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
        boolean visited[]=new boolean[n];
        return check(adj,source,destination,visited);
    }
}
// Using DFS
// T.C:O(n+E) In the worst case, the DFS traversal may visit all nodes and edges in the graph. Therefore, the time complexity of the DFS traversal is O(n + E).
// S.C:O(n+E): The space complexity of storing the adjacency list is O(n + E), where n are the number of nodes and E are the number of edges.