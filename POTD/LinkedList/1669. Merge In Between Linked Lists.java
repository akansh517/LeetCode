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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode left=null;
        ListNode right=list1;
        for(int i=0;i<b+1;i++){
            if(i==a-1){
                left=right;
            }
            right=right.next;
        }
        left.next=list2;
        ListNode temp=list2;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=right;
        return list1;
    }
}

// T.C:O(m+n) Visiting each node of list1 and list2 at least once
// S.C:O(1) we are taking only some pointers 



class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        List<Integer> list=new ArrayList<>();
        int index=0;
        ListNode current1=list1;
        while(index<a){
            list.add(current1.val);
            current1=current1.next;
            index++;
        }

        ListNode current2=list2;
        while(current2!=null){
            list.add(current2.val);
            current2=current2.next;
        }

        while(index<b+1){
            current1=current1.next;
            index++;
        }

        while(current1!=null){
            list.add(current1.val);
            current1=current1.next;
        }

        ListNode ans=new ListNode();
        ListNode temp=ans;
        for(int i=0;i<list.size();i++){
            ListNode node=new ListNode(list.get(i));
            temp.next=node;
            temp=temp.next;   
        }
        return ans.next;
    }
}


// T.C:O(m+n)   Both the list1 and list2 are traversing and added to the list
// S.C:O(n+m)We are using list, which can contain the values of list1 and list2. It can have at most n+m elements.Therefore, the space complexity is O(n+m)
