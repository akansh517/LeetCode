class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n=temp.length;
        int ans[]=new int [n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && temp[st.peek()]<=temp[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=0;
            }
            else{
                ans[i]=st.peek()-i; //calculating the days
            }
            st.push(i);
        }
        return ans;
    }
}


// T.C:O(n*2)==O(n) we are doing basically 2 operations(push or pop) for n elements at max so for n elements it will be n*2
// S.C:O(n) i.e temp.length




// class Solution {
//     public int[] dailyTemperatures(int[] temp) {
//         int n=temp.length;
//         int ans[]=new int [n];
//         for(int i=0;i<n;i++){
//             for(int j=i;j<n;j++){
//                 if(temp[i]<temp[j]){
//                     ans[i]=j-i;
//                     break;
//                 }
//             }
//         }
//         return ans;
//     }
// }


// T.C:O(n^2)
// S.C:O(n) i.e temp.length