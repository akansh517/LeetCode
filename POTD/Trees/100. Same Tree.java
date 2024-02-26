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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)  return true;
        if(p==null || q==null)  return false;
        Queue<TreeNode> que1=new LinkedList<>();
        Queue<TreeNode> que2=new LinkedList<>();
        que1.offer(p);
        que2.offer(q);
        while(!que1.isEmpty() && !que2.isEmpty()){
            TreeNode node1=que1.poll();
            TreeNode node2=que2.poll();
            if(node1.val!=node2.val){
                return false;
            }
            if(node1.left!=null && node2.left!=null){
                que1.offer(node1.left);
                que2.offer(node2.left);
            }
            else if(node1.left!=null || node2.left!=null){
                return false;
            }

            if(node1.right!=null && node2.right!=null){
                que1.offer(node1.right);
                que2.offer(node2.right);
            }
            else if(node1.right!=null || node2.right!=null){
                return false;
            }
        }
        return true;
    }
}
// using BFS(level order traversal)
//T.C : O(n)we are processing each node exactly once and does a constant 
// amount of work for each node
//S.C : O(n) In Worst case both que can hold all nodes of the 2 trees at the same level.



// using DFS
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        // If only one tree is null or the values are different, they are not identical
        if(p==null || q==null || p.val!=q.val){
            return false;
        }
      
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}


// T.C: O(min(N,M))O(min(N, M))O(min(N,M)), where N and M are the number of nodes in the
//  two trees, respectively. This is because we need to visit each node once in order to
// compare their values. In the worst case, 
// where both trees have the same number of nodes, the time complexity would be O(N).
// S.C:O(depth of tree) depending upon which tree is larger out of p and q Recursion stack space