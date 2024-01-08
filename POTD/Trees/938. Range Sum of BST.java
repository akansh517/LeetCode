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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
    //means the root is within the range so we add the root val along with left part+right part
        if(root.val>=low && root.val<=high){
            return root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
        }
    // waste to go left part bcz acc. to BST prop. left node will always be small than root
        if(root.val<low){
            return rangeSumBST(root.right,low,high);
        }
    // waste to go right part bcz acc. to BST prop. right node will always be large than root
        return rangeSumBST(root.left,low,high);
    }
}



// BST properties- 
// root.left node is always small than the root node
// root.right node is always greater than the root node

// So in this we can eliminate to explore the total number of nodes and make the solution efficient but in worst case it will explore all the nodes so 
// Overall T.C-O(n)
// S.C:O(1) Ignoring recursion stack space



// Brute traversing all the nodes without BST properties

// class Solution {
//     public int rangeSumBST(TreeNode root, int low, int high) {
//         if(root==null){
//             return 0;
//         }
//         int ans=0;
//         if(root.val>=low && root.val<=high){
//             ans+=root.val;
//         }
//         ans+=rangeSumBST(root.left,low,high);
//         ans+=rangeSumBST(root.right,low,high);
//         return ans;
//     }
// }
