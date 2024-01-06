class Solution {
    int n;
    int dp[];
    // Find the first job whose starting point >= currentJob's end point
    public int getNextJob(int arr[][],int start,int currentJobEndTime){
        int end=n-1;
        int result=n+1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid][0]>=currentJobEndTime){
                result=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return result;
    }

    public int solve(int arr[][],int i){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }

        int next=getNextJob(arr,i+1,arr[i][1]);
        int taken=arr[i][2]+solve(arr,next);
        int skip=solve(arr,i+1);
        return dp[i]=Math.max(taken,skip);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n=startTime.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);

        int arr[][]=new int[n][3];  //arr in which {startTime,endTime,profit} of each job
        for(int i=0;i<n;i++){
            arr[i][0]=startTime[i];
            arr[i][1]=endTime[i];
            arr[i][2]=profit[i];
        }

        // Sort the jobs according to the startTime
        Arrays.sort(arr,Comparator.comparingInt(vec->vec[0]));
        return solve(arr,0);
    }
}




// Recur + Memo
//T.C : O(nlogn), where n are the number of jobs
//S.C : O(n), where n are the number of jobs.