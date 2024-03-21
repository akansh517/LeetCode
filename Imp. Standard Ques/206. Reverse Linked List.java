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
    public ListNode reverseList(ListNode head) {
        ListNode dummy=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=dummy;
            dummy=head;
            head=next;
        }
        return dummy;
    }
}

// T.C:O(n)
// S.C:O(1)


class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> st=new Stack<>();
        while(head!=null){
            st.push(head);
            head=head.next;
        }

        ListNode node=new ListNode();
        ListNode temp=node;
        while(!st.isEmpty()){
            temp.next=st.pop();
            temp=temp.next;
        }
        temp.next=null;
        return node.next;
    }
}

// T.C:O(n)
// S.C:O(n)