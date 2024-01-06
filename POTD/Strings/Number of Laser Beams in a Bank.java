class Solution {
    public int numberOfBeams(String[] bank) {
        int n=bank.length;
        int prevDeviceCount=0;
        int ans=0;
        for(int i=0;i<n;i++){
            int currDeviceCount=0;
            for(char ch: bank[i].toCharArray()){
                if(ch=='1'){
                    currDeviceCount++;
                }
            }
            ans+=currDeviceCount*prevDeviceCount;
            if(currDeviceCount!=0){
                prevDeviceCount=currDeviceCount;
            }
            // if(currDeviceCount!=0){
            //     prevDeviceCount=currDeviceCount;
            // }
            prevDeviceCount=(currDeviceCount!=0)?currDeviceCount:prevDeviceCount;
        }
        return ans;
    }
}


// T.C:O(m*n) here m is the number of strings in the bank and n is the average length of the strings.
// We have to iterate over each character once to find the number of safety devices in each row and hence the time complexity is equal to O(M∗N).
// S.C:O(1) prevDeviceCount,currDeviceCount,ans variables 



// class Solution {
//     public int numberOfBeams(String[] bank) {

//         ArrayList<Integer> arr=new ArrayList<>();
//         for(String str:bank){
//             int cnt=0;
//             for(int i=0;i<str.length();i++){
//                 if(str.charAt(i)=='1'){
//                     cnt++;
//                 }
//             }
//             if(cnt!=0){
//                 arr.add(cnt);
//             }
//         }

//         int ans=0;
//         for(int i=1;i<arr.size();i++){
//             ans+=arr.get(i)*arr.get(i-1);
//         }
//         // System.out.println(arr);
//         return ans;
        
//     }
// }


// T.C:O(m*n)
// S.C:O(k) k is the size of the arraylist
