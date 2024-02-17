class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n=heights.length;
        // 1.Heap store k height difference that we need to use ladders.we are
        // using minheap to store the minelement at the top
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n-1;i++){
            int jumpLen=heights[i+1]-heights[i];
            // 2.Each move, if the height difference d > 0,we push d into the priority queue pq.
            // i.e we require jump 
            if(jumpLen>0){
                pq.offer(jumpLen);
            }
            
            // 3.If the size of pq exceed ladders,that means emergency occured,
            // it means we have to use bricks for one move.
            // 4.Then we pop out the smallest difference, and reduce bricks.
            if(pq.size()>ladders){
                bricks-=pq.poll();
            }
            
            // 5.If bricks < 0, we can't make this move, then we return current index i.
            if(bricks<0){
                return i;
            }
        }
        // 6.If we have reached outside the loop i.e we have reach the last building, we return n-1.
        return n-1;
    }
}


// T.C:O(nlogk) Heap D.S can contain only k elements where k are the number of ladders 
// S.C:O(k)



