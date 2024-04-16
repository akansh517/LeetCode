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
    public TreeNode add(TreeNode root,int val,int depth,int curr){
        if(root==null){
            return null;
        }
        if(curr==depth-1){
            TreeNode leftTemp=root.left;
            TreeNode rightTemp=root.right;
            root.left=new TreeNode(val);
            root.right=new TreeNode(val);
            root.left.left=leftTemp;
            root.right.right=rightTemp;
            return root;
        }

        root.left=add(root.left,val,depth,curr+1);
        root.right=add(root.right,val,depth,curr+1);
        return root;
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newRoot=new TreeNode(val);
            newRoot.left=root;
            return newRoot;
        }
        int curr=1;
        return add(root,val,depth,curr);
    }
}


// Using DFS
//T.C : O(n)
//S.C : O(1) Auxiliary Space, O(depth) system stack space of recursion