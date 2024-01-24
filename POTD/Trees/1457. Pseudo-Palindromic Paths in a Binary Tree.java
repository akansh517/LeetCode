/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result=0;
    public void solve(TreeNode root,int val){
        if(root!=null){
            val=val^(1<<root.val); //i want to set the kth bit then left shift the k with 1
            if(root.left==null && root.right==null){ //when i approached to the leaf node after that i will check how many set bits are set. If there is only 1 set bit which is set and other are 0 means all others are in pair and we know the property of xor i.e a^a=0 so the pairs will cancel out each other
                if((val&(val-1))==0){ //if the val is a power of 2 means it has only 1 bit set
                    result++;
                }
            }
            solve(root.left,val);
            solve(root.right,val);
        }
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        solve(root,0);
        return result;
    }
}
// Using bit manipulation 
// T.C:O(n)
// S.C:O(Height of tree) if we ignore the recursion stack space then it is O(1)



// class Solution {
//     int result=0;

//     public void solve(TreeNode root,int count[]){
//         if(root!=null){
//             count[root.val]++;
//             if(root.left==null && root.right==null){ //leaf node
//                 int oddFreq=0;
//                 for(int i=1;i<=9;i++){
//                     if(count[i]%2!=0){  //odd number
//                         oddFreq++;
//                     }
//                 }
//                 result+=(oddFreq<=1)?1:0;
//             }
//             solve(root.left,count);
//             solve(root.right,count);
//             count[root.val]--;
//         }
//     }

//     public int pseudoPalindromicPaths (TreeNode root) {
//         int count[]=new int[10];
//         solve(root,count);
//         return result;
//     }
// }

// The no. of oddElements in the path should be less than equal to 1 to be a palindromic path

// T.C:O(n)
// S.C:O(Height of tree) if we ignore the recursion stack space then it is O(1)
