class DSU{
    int parent[];
    int rank[];
    DSU(int n){
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }

    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }

    public void reset(int i){
        parent[i]=i;
    }

    public void Union(int x,int y){
        int x_parent=find(x);
        int y_parent=find(y);
        if(x_parent!=y_parent){
            if(rank[x_parent]<rank[y_parent]){
                parent[x_parent]=y_parent;
            }
            else if(rank[x_parent]>rank[y_parent]){
                parent[y_parent]=x_parent;
            }
            else{
                parent[x_parent]=y_parent;
                rank[y_parent]++;
            }
        }
    }
}



class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<int[]> meetingList=new ArrayList<>();
        for(int meeting[]:meetings){
            meetingList.add(meeting);
        }

        Comparator<int[]> compare=(a,b)->{
            if(a[2]==b[2]){
                return a[0]-b[0];
            }
            else{
                return a[2]-b[2];
            }
        };

        Collections.sort(meetingList,compare);

        DSU dsu=new DSU(n);
        dsu.Union(0,firstPerson);
        for(int i=0;i<meetingList.size();){
            List<Integer> curPeople=new ArrayList<>();
            int ct=meetingList.get(i)[2];
            while(i<meetingList.size() && meetingList.get(i)[2]==ct){
                curPeople.add(meetingList.get(i)[0]);
                curPeople.add(meetingList.get(i)[1]);
                dsu.Union(meetingList.get(i)[0],meetingList.get(i)[1]);
                i++;
            }

            for(int pep:curPeople){
                if(dsu.find(pep)!=dsu.find(0)){
                    dsu.reset(pep);
                }
            }
        }

        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(dsu.find(i)==dsu.find(0)){
                ans.add(i);
            }
        }
        return ans;
    }
}


// T.C:O(mlogm+ m*1 + n) mlogm bcz we are sorting meeting acc. to time and we are using 
// amortized O(1) bcz dsu is nearly O(1) and n is used for iterating over all nodes last for loop
// S.C:O(m+n) m is used for storing curPeople which have same meeting time and n
// is used for initializing the dsu i.e parent and rank array 
