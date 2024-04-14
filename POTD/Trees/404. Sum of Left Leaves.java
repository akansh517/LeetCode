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
    public int solve(TreeNode curr,TreeNode parent){
        if(curr==null){
            return 0;
        }
        int sum=0;
        if(curr.left==null && curr.right==null){
            if(parent!=null && parent.left==curr){
                sum+=curr.val;
            }
        }

        int left=solve(curr.left,curr);
        int right=solve(curr.right,curr);

        return left+right+sum;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        TreeNode parent=null;
        return solve(root,parent);
    }
}
// Using parent pointer 
//T.C : O(n)
//S.C : O(1) Auxiiliary Space and O(depth of tree) recursion system stack space




class Solution {
    public int solve(TreeNode curr,boolean isLeft){
        int sum=0;
        if(curr==null){
            return 0;
        }

        if(curr.left==null && curr.right==null && isLeft==true){
            return curr.val;
        }

        sum+=solve(curr.left,true);
        sum+=solve(curr.right,false);

        return sum;


    }
    public int sumOfLeftLeaves(TreeNode root) {
        return solve(root,false);
    }
}

//T.C : O(n)
//S.C : O(1) Auxiiliary Space and O(depth of tree) recursion system stack space