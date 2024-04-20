class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> ans=new ArrayList<>();
        int m=land.length;
        int n=land[0].length;
        for(int r1=0;r1<m;r1++){
            for(int c1=0;c1<n;c1++){
                if(land[r1][c1]==1){
                    int r2=r1,c2=c1;
                    for(r2=r1;r2<m && land[r2][c1]!=0 ;r2++){
                        for(c2=c1;c2<n && land[r2][c2]!=0; c2++){
                            land[r2][c2]=0;
                        }
                    }
                    int arr[]={r1,c1,r2-1,c2-1};
                    ans.add(arr);
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}


// T.C:O(m*n)
// S.C:O(m*n)