class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
        return nums[0];
        if(nums.length==2)
        return Math.max(nums[0], nums[1]);
         if(nums.length==3)
        return Math.max(nums[0], Math.max(nums[1], nums[2]));
        int n = nums.length;
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        int max_1 = 0;
        for(int i = 2; i < n-1; i++){
               max_1 = Math.max(prev + nums[i], curr);
               prev = curr;
               curr = max_1;
        }
        prev = nums[1];
        curr = Math.max(nums[1], nums[2]);
         int max_2 = 0;
        for(int i = 3; i < n; i++){
               max_2 = Math.max(prev + nums[i], curr);
               prev = curr;
               curr = max_2;
        }
      return Math.max(max_1, max_2);
    }
}
