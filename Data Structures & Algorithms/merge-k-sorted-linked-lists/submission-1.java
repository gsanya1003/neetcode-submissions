class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // 1. Add only the head of each list to the heap (heap size <= k)
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // 2. Process nodes one by one
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node; // Reuse existing node
            curr = curr.next;

            // Push next element of the same list into heap
            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return dummy.next;
    }
}