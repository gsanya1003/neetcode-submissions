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
    public ListNode mergeKLists(ListNode[] lists) {
      PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
      for(int i = 0; i < lists.length; i++){
        ListNode head = lists[i];
        while(head!=null){
            pq.add(new ListNode(head.val));
            head=head.next;
        }
      }
      ListNode ans = pq.poll(), res = ans;
      while(!pq.isEmpty()){
        ListNode root = pq.poll();
         ans.next = root;
         ans = ans.next;
        
      }
      return res;
    }
}
