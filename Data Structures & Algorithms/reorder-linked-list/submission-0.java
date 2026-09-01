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
        ListNode lengt = head;
       int n = len(lengt);
       if(n==1)
       return ;
       int mid = 0;
       if(n%2==0){
         mid = n/2;
       }
       else
       {
        mid = n/2 + 1;
       }
       System.out.println(mid + "  " +  n);
       int i = 1;
       ListNode root = head, curr1 = head, nextf1 = curr1.next, res = head;
       while(i!=mid){
           i = i+1;
           root=root.next;
       }

       ListNode curr = root.next;
       ListNode prev = null,nextf;
       while(curr!=null){
        nextf = curr.next;
        curr.next = prev;
        prev = curr;
        curr=nextf;

       }
       root.next = null;
       curr = prev;
       nextf = curr.next;
       while(curr!=null){
        nextf = curr.next;
        nextf1=curr1.next;
        curr1.next = curr;
        curr.next = nextf1;
        curr1 = nextf1;
       // nextf1.next = nextf;
        curr = nextf;
        //nextf = nextf.next;
        //nextf1=nextf1.next;

       }
      // if(nextf1!=null)
       //curr1.next 
     // return res;
        
    }

    public int len(ListNode head){
        if(head == null)
        return 0;
        return len(head.next) + 1;
    }
}
