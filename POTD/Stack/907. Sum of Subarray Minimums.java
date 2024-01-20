class Solution {
    public int[] getNSL(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        //This is just we are finding next smaller to each element to left
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) { //strictly less
                st.pop();
            }

            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return result;
    }

    public int[] getNSR(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        //This is just we are finding next smaller to each element to right
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {//non-strictly less
                st.pop();
            }

            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return result;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] NSL = getNSL(arr, n);//Next smaller to left
        int[] NSR = getNSR(arr, n);//Next smaller to right

        long sum = 0;
        int M = 1000000007;

        for (int i = 0; i < n; i++) {
            long d1 = i - NSL[i];//distance to nearest smaller to left from i
            long d2 = NSR[i] - i;//distance to nearest smaller to right from i
             /*
                we have d1 numbers in the left and d2 numbers in the right
                i.e. We have d1 options to start from the left of arr[i] 
                and d2 options to end in the right of arr[i]
                so the total options to start and end are d1*d2
            */
            long totalWaysForIMin = d1 * d2;
            long sumIInTotalWays = arr[i] * totalWaysForIMin;

            sum = (sum + sumIInTotalWays) % M;
        }

        return (int) sum;
    }
}


//T.C : O(n)
//S.C : O(n)



// class Solution {
//     int mod=(int)1e9+7;
//     public int sumSubarrayMins(int[] arr) {
//         int n=arr.length;
//         int sum=0;
//         for(int i=0;i<n;i++){
//             int min=Integer.MAX_VALUE;
//             for(int j=i;j<n;j++){
//                 min=Math.min(min,arr[j]);
//                 sum=(sum+min)%mod;
//             }
//         }
//         return sum;
//     }
// }
// T.C:O(n^2)
// S.C:O(1)



// class Solution {
//     int mod=(int)1e9+7;
//     public int sumSubarrayMins(int[] arr) {
//         int n=arr.length;
//         int sum=0;
//         for(int i=0;i<n;i++){
//             for(int j=i;j<n;j++){
//                 int min=Integer.MAX_VALUE;
//                 for(int k=i;k<=j;k++){
//                     min=Math.min(min,arr[k]);
//                 }
//                 sum=(sum+min)%mod;
//             }
//         }
//         return sum;
//     }
// }
// T.C:O(n^3)
// S.C:O(1)