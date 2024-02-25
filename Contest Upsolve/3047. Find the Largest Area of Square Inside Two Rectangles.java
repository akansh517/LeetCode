class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n=topRight.length;
        long area=0;
        for(int i=0;i<n;i++){   //checking all 2 possible pairs of rectangle
            for(int j=i+1;j<n;j++){
                long minX=Math.max(bottomLeft[i][0],bottomLeft[j][0]);
                long minY=Math.max(bottomLeft[i][1],bottomLeft[j][1]);
                long maxX=Math.min(topRight[i][0],topRight[j][0]);
                long maxY=Math.min(topRight[i][1],topRight[j][1]);
                if(maxX>minX && maxY>minY){ //if i got common rectangle then pick
                    long side=Math.min(maxX-minX,maxY-minY);//smallest length to form common square
                    area=Math.max(area,side*side);
                }
            }
        }
        return area;
    }
}

// T.C:O(n^2)
// S.C:O(1)