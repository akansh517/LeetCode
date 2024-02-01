class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int result[][]=new int[n/3][3];
        int l=0;
        for(int i=0;i<n;i+=3){
            if(nums[i+2]-nums[i]>k){
                return new int[][]{};
            }
            else{
                result[l][0]=nums[i];
                result[l][1]=nums[i+1];
                result[l][2]=nums[i+2];
                l++;
            }
        }
        return result;
    }
}


// T.C:O(nlogn) due to sorting 
// S.C:O(logn)




class Solution {
    public boolean isPossible(int arr[],int k){
        int n=arr.length;
        if(arr[n-1]-arr[0]<=k){
            return true;
        }
        return false;
    }
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        int subArrays=n/3;
        Arrays.sort(nums);
        List<int[]> output=new ArrayList<>();
        for(int i=0;i<n;i+=3){
            int arr[]=new int[3];
            int m=0;
            for(int j=i;j<i+3;j++){
                arr[m]=nums[j];
                m++;
            }
            if(isPossible(arr,k)){
                output.add(arr);
            }
        }
        if(output.size()!=subArrays){
            return new int[][]{};
        }
        return output.toArray(new int[output.size()][]);
    }
}
