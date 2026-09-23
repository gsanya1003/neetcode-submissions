class Solution {
     int arr[][];
    public int lengthOfLIS(int[] nums) {
      
        int n = nums.length;
         arr = new int[n][n+1];
        for(int [] row: arr)
        Arrays.fill(row, -1);
        
       return dfs(0, -1, nums);

    }

    public int dfs(int i, int j, int[] nums){
        if(i==nums.length)
        return 0;
        if(arr[i][j+1]!=-1)
        return arr[i][j+1];
        int val =  dfs(i+1, j, nums);
        if(j==-1 || nums[i] > nums[j])
        val = Math.max(val,1 + dfs(i+1, i, nums));
        return arr[i][j+1]=val;
    }
}
