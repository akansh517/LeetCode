class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        int cnt=1;
        int prev[]=points[0];
        for(int i=1;i<points.length;i++){
            int currStart=points[i][0];
            int currEnd=points[i][1];
            int prevStart=prev[0];
            int prevEnd=prev[1];

            if(currStart>prevEnd){//No overlapping
                cnt++;
                prev=points[i];
            }
            else{//overlap
                prev[0]=Math.max(prevStart,currStart);
                prev[1]=Math.min(prevEnd,currEnd);
            }
        }
        return cnt;
    }
}

// Sorting on the basis of "Start Coordinate"
// T.C : O(nlogn)
// S.C : O(1)