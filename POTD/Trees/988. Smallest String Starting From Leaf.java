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
    String result="";
    public void solve(TreeNode root,String curr){
        if(root==null){
            return;
        }
        curr=(char)(root.val+'a')+curr;// This will take O(length of curr)
        if(root.left==null && root.right==null){
            if(result.equals("") || result.compareTo(curr)>0){
                result=curr;
            }
            return;
        }
        solve(root.left,curr);
        solve(root.right,curr);
    }
    public String smallestFromLeaf(TreeNode root) {
        solve(root,"");
        return result;
    }
}

// Using DFS
//T.C : O(n)
//S.C : O(n) space taken for resurion system stack