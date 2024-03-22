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
            ListNode next=head.next;
            head.next=dummy;
            dummy=head;
            head=next;
        }
        return dummy;
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        
        ListNode slow=head;
        ListNode fast=head;

        // Finding the middle node of the LinkedList O(n/2)
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        slow.next=reverse(slow.next);//reversing the right half O(n/2)
        slow=slow.next; //move the slow to the head of the reverse half

        while(slow!=null){  //Traversing only half LinkedList O(n/2)
            if(head.val!=slow.val){
                return false;
            }
            slow=slow.next;
            head=head.next;
        }
        return true;
    }
}

// T.C:O(n/2+n/2+n/2)===O(n)
// S.C:O(1)
    


class Solution {
    public ListNode reverse(ListNode head){
        ListNode dummy=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=dummy;
            dummy=head;
            head=next;
        }
        return dummy;
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }

        ListNode copy=new ListNode(head.val);
        ListNode copyPtr=copy;
        ListNode ptr=head.next;
        while(ptr!=null){
            copyPtr.next=new ListNode(ptr.val);
            copyPtr=copyPtr.next;
            ptr=ptr.next;
        }

        ListNode list=reverse(head);
        while(list!=null){
            if(list.val==copy.val){
                copy=copy.next;
                list=list.next;
            }
            else{
                return false;
            }
        }
        return true;
    }
}

// T.C:O(n)
// S.C:O(n) bcz we are copying the original linkedlist