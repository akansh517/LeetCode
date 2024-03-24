class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        Map<Long,Long> mp=new HashMap<>();
        int n=nums.length;
        long ans[]=new long[n];
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(b[0],a[0]));//maxheap
        for(int i=0;i<n;i++){//O(n)
            long ID=nums[i];
            long F=freq[i];
            mp.put(ID,mp.getOrDefault(ID,0L)+F);
            pq.offer(new long[]{mp.get(ID),ID});//O(logn) storing {freq,ID}

            // Checking for the stale entries 
            while(!pq.isEmpty() && mp.get(pq.peek()[1])!=pq.peek()[0]){ //O(n)
                pq.poll();  //O(log(size of heap)) i.e log(n)
            }
            ans[i]=pq.peek()[0];
        }
        return ans;
    }
}



// T.C:O(n*(logn+nlogn))===O(n^2logn) in worst case
// T.C to be extreme worst but the amortised complexity will be O(nlogn) because we won’t have to remove the stale entries every time.Once we remove stale entries, we may not have to remove stale entries again for quite a few more operations. 
// So it becomes amortized O(nlogn) overall
// T.C:O(nlogn)

// Map and PriorityQueue will have the maximum size n so 
// S.C:O(n)