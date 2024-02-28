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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);
        int result=root.val;
        while(!que.isEmpty()){
            TreeNode node=que.poll();
            result=node.val;
            if(node.right!=null){
                que.offer(node.right);
            }
            if(node.left!=null){
                que.offer(node.left);
            }
        }
        return result;
    }
}

//T.C : O(n)
//S.C : O(n) for queue





class Solution {
    int maxDepth;
    int bottomLeft;
    public void solve(TreeNode root,int currDepth){
        if(root==null){
            return;
        }
        if(currDepth>maxDepth){
            maxDepth=currDepth;
            bottomLeft=root.val;
        }
        solve(root.left,currDepth+1);
        solve(root.right,currDepth+1);
    }
    public int findBottomLeftValue(TreeNode root) {
        maxDepth=-1;
        solve(root,0);
        return bottomLeft;
    }
}

// T.C:O(n)
// S.C:O(depth of tree)
// auxilary S.C:O(1)
