class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
        return nums[0];
        if(nums.length==2)
        return Math.max(nums[0], nums[1]);
        int prev = nums[0];
        int curr =  Math.max(nums[0], nums[1]);
        int n = nums.length;
       int max = 0;
        for(int i = 2; i < n; i++){
            max = Math.max(prev + nums[i], curr);
            prev = curr;
            curr = max;
        }

         return max;
        
    }
}
