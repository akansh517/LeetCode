class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            return Collections.singletonList(0);
        }
        Map<Integer,List<Integer>> adj=new HashMap<>();
        int indegree[]=new int[n];
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            indegree[u]++;
            indegree[v]++;
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }        

        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==1){// adding all leaf nodes so that we can remove them later
                que.offer(i);
            }
        }

        while(n>2){
            int size=que.size();
            n-=size;// removing nodes with indegree 1
            while(size-->0){
                int elem=que.poll();
                for(int v:adj.getOrDefault(elem,Collections.emptyList())){
                    indegree[v]--;
                    if(indegree[v]==1){
                        que.offer(v);
                    }
                }
            }
        }
        List<Integer> result=new ArrayList<>();
        while(!que.isEmpty()){
            result.add(que.poll());
        }
        return result;
    }
}

// If the no. of nodes are odd then there will be atmost 1 ans other if there are even no. of nodes then there will be atmost 2 ans possible and also we will not consider leaf nodes bcz we know that if we consider the leaf nodes then they will have max. height so we will go inwards till we have not reached the central nodes so overall Time complexity will be 

//Using Topological Sorting
//T.C : O(V+E)
//S.C : O(V+E)



//NOTE : You can do a brute force to do DFS from each node treating them as root and keep finding the Height in every case. That will give TLE.
