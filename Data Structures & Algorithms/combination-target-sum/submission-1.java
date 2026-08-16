class Solution {
     List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int n = nums.length;
        res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        combine(nums, target, n, arr, 0);
        return res;
        
    }
    public void combine(int[] nums, int target, int n, List<Integer> arr, int i){
         // System.out.println(sum);
          if( target == 0){
            //System.out.println("Got the sum " + arr);
            res.add(new ArrayList(arr));
            return;
           }
           if(i>=n ||  target < 0){
          
            return;
           }
          
         
           combine(nums, target , n,arr, i + 1 );
           //System.out.println(sum+ " i not taken " + arr);
           arr.add(nums[i]);
          // sum = sum + nums[i];
           // System.out.println(sum+ " i  taken " + arr);
           combine(nums, target - nums[i], n,  arr,i );
            arr.remove(arr.size()-1);
           
    }
}
