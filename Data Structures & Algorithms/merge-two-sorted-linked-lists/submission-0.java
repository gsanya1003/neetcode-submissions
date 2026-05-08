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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)
        return list2;
        if(list2==null)
        return list1;
       // ListNode head = null;
        ListNode head = new ListNode(0);
        ListNode node = head;

        
        ListNode head1=list1, head2 = list2, temp1 = head1.next, temp2 = head2.next;
        while(head1!=null && head2!=null){
            if(head1.val < head2.val){
                node.next = head1;
               
               
                head1=head1.next;
            }
            else{
                 node.next = head2;
               
               
                head2=head2.next;
                
            }
            node = node.next;
            

        }
        if(head1!=null)
        node.next=head1;
        else
        node.next = head2;
        return head.next;
        
    }
}