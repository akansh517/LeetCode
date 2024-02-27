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
    public int solve(TreeNode root,int ans[]){
        if(root==null){
            return 0;
        }
        int leftHeight=solve(root.left,ans);
        int rightHeight=solve(root.right,ans);
        ans[0]=Math.max(leftHeight+rightHeight,ans[0]);
        return 1+Math.max(leftHeight,rightHeight);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ans[]={Integer.MIN_VALUE};
        solve(root,ans);
        return ans[0];
    }
}

//T.C : O(n)
//S.C : O(depth of tree) - Recursion System Stack Space