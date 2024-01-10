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
    public void solve(TreeNode root,StringBuilder leaf){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            leaf.append(root.val).append("_");
            // return;
        }
        solve(root.left,leaf);
        solve(root.right,leaf);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        solve(root1,s1);
        solve(root2,s2);
        String sb1=s1.toString();
        String sb2=s2.toString();
        return sb1.equals(sb2);
    }
}

// T.C:O(T1+T2) length of both trees T1 and T2
// S.C:O(T1+T2) two ArrayList which are used for storing leaf nodes





// class Solution {
//     public void solve(TreeNode root,List<Integer> leaves){
//         if(root==null){
//             return;
//         }
//         if(root.left==null && root.right==null){
//             leaves.add(root.val);
//         }
//         solve(root.left,leaves);
//         solve(root.right,leaves);
//     }
//     public boolean leafSimilar(TreeNode root1, TreeNode root2) {
//         ArrayList<Integer> leftTree=new ArrayList<>();
//         ArrayList<Integer> rightTree=new ArrayList<>();
//         solve(root1,leftTree);
//         solve(root2,rightTree);
//         return leftTree.equals(rightTree);
//     }
// }

// T.C:O(T1+T2) length of both trees T1 and T2
// S.C:O(T1+T2) two ArrayList which are used for storing leaf nodes