class Solution {
    public int findJudge(int n, int[][] trust) {
        int count[]=new int[n+1]; //incoming arrows
        for(int t[]:trust){
            count[t[1]]++;
            count[t[0]]--;
        }
        for(int i=1;i<=n;i++){
            if(count[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}

// Directed Graph- Count the degree, and check at the end.
// The point with in-degree - out-degree = N - 1 become the judge.
// T.C:O(T+n)
// S.C:O(n) due to the 1 array count



class Solution {
    public int findJudge(int n, int[][] trust) {
        int indegree[]=new int[n+1]; //incoming arrows
        int outdegree[]=new int[n+1];  //outgoing arrows
        for(int t[]:trust){
            int in=t[1];
            int out=t[0];
            indegree[in]++;
            outdegree[out]--;
        }
        for(int i=1;i<=n;i++){
            if(indegree[i]==n-1 && outdegree[i]==0){
                return i;
            }
        }
        return -1;
    }
}

// indegree[i]==n-1 means all people trust him(except him) and outdegree[i]==0 means he
//  does not trust anybody
// T.C:O(T+n)
// S.C:O(2n) due to the 2 arrays indegree and outdegree