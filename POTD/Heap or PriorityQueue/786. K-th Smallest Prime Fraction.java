class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n=arr.length;
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                double frac=(double)arr[i]/arr[j];
                pq.add(new double[]{frac,(double)arr[i],(double)arr[j]});
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        double vec[]=pq.poll();
        int ans[]=new int[2];

        ans[0]=(int)vec[1];
        ans[1]=(int)vec[2];
        return ans;

    }
}

// Using simple Heap solution as it's asking for kth smallest
// //T.C : O(n^2 * log(k))
// //S.C : O(k)