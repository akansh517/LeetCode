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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer,ListNode> mp=new HashMap<>();
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        mp.put(0,dummy);
        int prefixSum=0;
        while(head!=null){
            prefixSum+=head.val;
            if(mp.containsKey(prefixSum)){
                ListNode node=mp.get(prefixSum);
                ListNode start=node;
                int pSum=prefixSum;
                while(start!=head){
                    start=start.next;
                    pSum+=start.val;
                    if(start!=head){
                        mp.remove(pSum);
                    }
                }
                node.next=head.next;
            }
            else{
                mp.put(prefixSum,head);
            }
            head=head.next;
        }
        return dummy.next;
    }
}


//T.C : O(n^2)
//S.C : O(n) - due to the map
