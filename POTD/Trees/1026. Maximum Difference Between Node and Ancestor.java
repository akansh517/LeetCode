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
    public int maxDifference(TreeNode root,int minVal,int maxVal){
        if(root==null){
            return Math.abs(maxVal-minVal);
        }
        minVal=Math.min(minVal,root.val);
        maxVal=Math.max(maxVal,root.val);
        int left=maxDifference(root.left,minVal,maxVal);
        int right=maxDifference(root.right,minVal,maxVal);
        return Math.max(left,right);
    }

    public int maxAncestorDiff(TreeNode root) {
        return maxDifference(root,root.val,root.val);
    }
}


//Optimal (O(n)) using min and max value for |min-max|




// class Solution {
//     int maxDiff;
//     public void maxDiffUtil(TreeNode root,TreeNode child){
//         if(root==null || child==null){
//             return;
//         }
//         maxDiff=Math.max(maxDiff,Math.abs(root.val-child.val));
//         maxDiffUtil(root,child.left);
//         maxDiffUtil(root,child.right);
//     }

//     public void maxDiff(TreeNode root){
//         if(root==null)  return;
//         maxDiffUtil(root,root.left);
//         maxDiffUtil(root,root.right);
//         maxDiff(root.left);
//         maxDiff(root.right);
//     }

//     public int maxAncestorDiff(TreeNode root) {
//         maxDiff=-1;
//         maxDiff(root);
//         return maxDiff;
//     }
// }



//Approach-1 (Brute Force) - O(n^2) - n = number of nodes in the Tree
/*
  Just simply take a root, find all the differences of it from its childres and find max one
  Again go to root->left and do the same as above
  Again go to root->right and do the same as above
*/
