class Solution {
    public int findKthLargest(int[] nums, int k) {
       int m = nums.length - k + 1;
       System.out.println(m);
       int c = 0;
        PriorityQueue<Integer> ps = new PriorityQueue();
        for(int i = 0;  i < nums.length; i++){
             ps.add(nums[i]);
             if(ps.size()  > k)
               ps.poll();
        }
      
        
        return ps.peek();
        
    }
}
