class Solution {
    long result_base_node=0;
    int N;
    int count[];

    public int DFSBase(Map<Integer,List<Integer>> adj,int curr_node,int prev_node,int curr_depth){
        int totalCount=1;
        result_base_node+=curr_depth;
        List<Integer> children=adj.get(curr_node);
        if(children!=null){
            for(int child: children){
                if(child==prev_node){
                    continue;
                }
                totalCount+=DFSBase(adj,child,curr_node,curr_depth+1);
            }
        }
        count[curr_node]=totalCount;
        return totalCount;
    }

    public void DFS(Map<Integer,List<Integer>> adj,int parent_node,int prev_node,int result[]){
        List<Integer> children=adj.get(parent_node);
        if(children!=null){ 
            for(int child:children){
                if(child==prev_node){
                    continue;
                }
                result[child]=result[parent_node]-count[child]+(N-count[child]);
                DFS(adj,child,parent_node,result);
            }
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N=n;
        count=new int[n];
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
        result_base_node=0;
        DFSBase(adj,0,-1,0);
        
        int result[]=new int[n];
        result[0]=(int)result_base_node;
        DFS(adj,0,-1,result);
        return result;
    }
}


// The loop iterating over the edges runs in O(E) time, where E is the number of edges in the graph.Depth-first search (DFS) to compute subtree counts and the base node result: In the worst case, the DFS visits each node and each edge once, resulting in O(V + E) time complexity, where V is the number of vertices in the graph.Another DFS to compute the final results: Similar to the previous DFS, it also takes O(V + E) time.

// Time complexity: O(V + E)
// Space complexity: O(V + E) building the adjacency list 
// Here, V represents the number of vertices (nodes) in the graph, and E represents the number of edges.