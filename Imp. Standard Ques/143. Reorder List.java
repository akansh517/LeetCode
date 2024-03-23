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
    public void reorderList(ListNode head) {
        Stack<ListNode> st=new Stack<>();
        ListNode curr=head;
        while(curr!=null){
            st.push(curr);
            curr=curr.next;
        }
        int k=st.size()/2;
        curr=head;
        while(k-->0){
            ListNode topNode=st.pop();
            ListNode temp=curr.next;
            curr.next=topNode;
            topNode.next=temp;
            curr=temp;
        }
        curr.next=null;
    }
}

// Using stack
// T.C : O(n)
// S.C : O(n)

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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        // slow=slow.next;
        System.out.println(slow.val);
        ListNode rev=reverse(slow);
        ListNode curr=head;
        while(rev.next!=null){
            ListNode temp=curr.next;
            curr.next=rev;
            ListNode tempRev=rev.next;
            rev.next=temp;
            curr=temp;
            rev=tempRev;
        }
    }
}

// T.C:O(n)
// S.C:O(n) due to the recursive stack space


// My Approach 

class Solution {
    public void reorderList(ListNode head) {
        Queue<ListNode> que=new LinkedList<>();
        Stack<ListNode> st=new Stack<>();

        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        
        slow=slow.next;

        ListNode temp=head;
        ListNode curr=temp;
        while(curr!=slow){
            que.offer(curr);
            curr=curr.next;
        }
        
        while(slow!=null){
            st.push(slow);
            slow=slow.next;
        }


        System.out.println(que.size());
        System.out.println(st.size());

        while(!que.isEmpty()){
            temp.next=que.poll();
            temp=temp.next;
            if(!st.isEmpty()){
                temp.next=st.pop();
                temp=temp.next;
            }
        }
        temp.next=null;

    }
}
