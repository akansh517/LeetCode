class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int result=0;
        // First take rowWise cumulative sum horizontally 
        for(int row=0;row<rows;row++){
            for(int col=1;col<cols;col++){
                matrix[row][col]+=matrix[row][col-1];
            }
        }
        // Now we need to find the no. of subarrays with sum==target subproblem(Subarray sum equals K LC-560) - in Downward direction Vertically
        for(int startCol=0;startCol<cols;startCol++){
            for(int j=startCol;j<cols;j++){
                // We need to find all submatrices sum Now comes the concept of "No. of subarrays with sum equals to target"
                Map<Integer,Integer> mp=new HashMap<>(); 
                mp.put(0,1);
                int cum_sum=0;
                // Go downwards row-wise
                for(int row=0;row<rows;row++){
                    cum_sum+=matrix[row][j]-(startCol>0?matrix[row][startCol-1]:0);
                    if(mp.containsKey(cum_sum-target)){
                        result+=mp.get(cum_sum-target);
                    }
                    mp.put(cum_sum,mp.getOrDefault(cum_sum,0)+1);
                }
            }
        }
        return result;
    }
}
// Using prefix sum
//T.C : O(cols*cols * rows)=== O(n^2 * m)
//S.C : O(m) due to the map 



// class Solution {
//     public int numSubmatrixSumTarget(int[][] matrix, int target) {
//         int m=matrix.length;
//         int n=matrix[0].length;
//         int cnt=0;
//         for(int s_r=0;s_r<m;s_r++){
//             for(int s_c=0;s_c<n;s_c++){
//                 for(int e_r=s_r;e_r<m;e_r++){
//                     for(int e_c=s_c;e_c<n;e_c++){
//                         int sum=0;
//                         for(int i=s_r;i<=e_r;i++){
//                             for(int j=s_c;j<=e_c;j++){
//                                 sum+=matrix[i][j];
//                             }
//                         }
//                         if(sum==target){
//                             cnt++;
//                         }
//                     }
//                 }
//             }
//         }
//         return cnt;
//     }
// }


// T.C:O (m^3)*(n^3)
// S.C:O(1)