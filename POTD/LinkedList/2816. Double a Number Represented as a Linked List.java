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
    public ListNode reverse(ListNode head){
        ListNode dummy=null;
        while(head!=null){
            ListNode temp=head.next;
            head.next=dummy;
            dummy=head;
            head=temp;
        }
        return dummy;
    }
    public ListNode doubleIt(ListNode head) {
        head=reverse(head);
        int carry=0;
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            int newVal=curr.val*2+carry;
            curr.val=newVal%10;
            if(newVal>=10){
                carry=1;
            }
            else{
                carry=0;
            }
            prev=curr;
            curr=curr.next;
        }
        if(carry!=0){
            ListNode newHead=new ListNode(carry);
            prev.next=newHead;
        }
        return reverse(head);
    }
}


// Using Reverse of LinkedList
// T.C : O(n)
// S.C : O(n)