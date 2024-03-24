class Solution {
    public int minOperations(int k) {
        int minOps=Integer.MAX_VALUE;
        for(int op=1;op<=k;op++){
            int gps=(int)Math.ceil(k/(double)op);
            minOps=Math.min(minOps,op-2+gps);
        }
        return minOps;
    }
}


// T.C:O(k)
// S.C:O(1)