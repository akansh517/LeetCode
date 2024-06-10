class Solution {
    public int heightChecker(int[] heights) {
        int n=heights.length;
        int expected[]=new int[n];
        for(int i=0;i<n;i++){
            expected[i]=heights[i];
        }
        Arrays.sort(heights);
        int cnt=0;
        for(int i=0;i<n;i++){
            if(heights[i]!=expected[i]){
                cnt++;
            }
        }
        return cnt;
    }
}
// T.C:O(nlogn)
// S.C:O(n)