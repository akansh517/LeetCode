class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        List<int[]> result=new ArrayList<>();
        int i=0;
        while(i<n){
            if(intervals[i][1]<newInterval[0]){
                result.add(intervals[i]);
            }
            else if(intervals[i][0]>newInterval[1]){
                break;
            }
            else{// Merge the intervals and check further
                newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
                newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            }
            i++;
        }
        result.add(newInterval);
        while(i<n){
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
}


// T.C:O(n)
// S.C:O(n)



class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }
        List<int[]> list=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));  //O(nlogn)
        int currinterval[]=intervals[0];
        list.add(currinterval);
        for(int interval[]:intervals){
            int currStart=currinterval[0];
            int currEnd=currinterval[1];
            int nextStart=interval[0];
            int nextEnd=interval[1];
            if(nextStart<=currEnd){
                currinterval[1]=Math.max(nextEnd,currEnd);
            }
        
            else{
                currinterval=interval;
                list.add(currinterval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        boolean inserted = false;

        for (int[] interval : intervals) {
            if (!inserted && interval[0] > newInterval[0]) {
                merged.add(newInterval);
                inserted = true;
            }
            merged.add(interval);
        }

        if (!inserted) {
            merged.add(newInterval);
        }

        int mergeInterval[][]=merged.toArray(new int[merged.size()][]);
        return merge(mergeInterval);
    }
}


// T.C:O(nlogn)
// S.C:O(n)