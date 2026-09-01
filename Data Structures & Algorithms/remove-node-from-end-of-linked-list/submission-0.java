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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       
        ListNode root = head;
        int m = len(root);
        root = head;
        int j = m - n + 1;
        if(j==1){
            head=head.next;
            return head;
        }
        int i = 1;
        ListNode up = root.next;
        while(i!=j-1){
            // System.out.println(root.val + "  " + up.val);
            root=root.next;
            up = up.next;
            i=i+1;

        } 
        System.out.println(root.val + "  " + up.val);
        root.next = up.next;
        //System.out.println(root.val + "  " + up.val);
        return head;


    }
    public int len(ListNode head){
        if(head==null)
        return 0;
        return len(head.next) + 1;
    }
}
