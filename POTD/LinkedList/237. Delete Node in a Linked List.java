/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
// T.C:O(1)The method involves a constant number of operations: updating the data of the current node and altering its next pointer. Each of these operations requires a fixed amount of time, irrespective of the size of the linked list.
// S.C:O(1)This deletion technique does not necessitate any extra memory allocation, as it operates directly on the existing nodes without creating additional data structures.




class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev=null;
        while(node!=null && node.next!=null){
            node.val=node.next.val;
            prev=node;
            node=node.next;
        }
        if(node!=null){
            if(prev!=null){
                prev.next=null;
            }
            else{
                node=null;
            }
        }
    }
}


// T.C:O(n)
// S.C:O(1)