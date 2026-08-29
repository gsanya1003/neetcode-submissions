class Solution {
    public int findMin(int[] nums) {
        int n = nums.length - 1;
        int i = 0, j = n;
        if(nums[i] < nums[j])
        return nums[i];
       
            while(i < j){
                
                int mid = (i+j)/2;
                
                if(nums[mid] > nums[j]){
                    i = mid+1;
                }
                else
                {
                    j = mid;
                }
            }

        return nums[i];

    }
}
