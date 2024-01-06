class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;
        while(i<g.length && j<s.length){
            if(s[j]>=g[i]){
                i++;
            }
            j++;
        }
        return i;
    }
}


// class Solution {
//     public int findContentChildren(int[] g, int[] s) {
//         int m=g.length;
//         int n=s.length;
//         Arrays.sort(g);
//         Arrays.sort(s);
//         int cnt=0;
//         int i=0;
//         int j=0;
//         while(i<m && j<n){
//             if(s[j]>=g[i]){
//                 cnt++;
//                 i++;
//             }
//             j++;
//         }
//         return cnt;
//     }
// }

// T.C:O(nlogn+mlogm)
// S.C:O(logn+logm)