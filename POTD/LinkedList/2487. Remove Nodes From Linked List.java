/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st=new Stack<>();
        ListNode current=head;
        while(current!=null){
            st.push(current);
            current=current.next;
        }
        current=st.pop();
        int maxi=current.val;
        ListNode result=new ListNode(maxi);
        while(!st.isEmpty()){
            current=st.pop();
            if(current.val<maxi){
                continue;
            }
            else{
                ListNode newNode=new ListNode(current.val);
                newNode.next=result;
                result=newNode;
                maxi=current.val;
            }
        }
        return result;
    }
}


// T.C:O(n)Adding the nodes from the original linked list to the stack takes O(n).
// Removing nodes from the stack and adding them to the result takes O(n), as each node is popped from the stack exactly once.
// Therefore, the time complexity is O(2n), which simplifies to O(n).
// S.C:O(n)We add each of the nodes from the original linked list to the stack, making its size n.We only use resultList to store the result, so it does not contribute to the space complexity.Therefore, the space complexity is O(n).