class Solution {
    public int coinChange(int[] coins, int amount) {
     int arr[][] = new int[amount+1][coins.length+1];
      
      
      for(int i = 0; i <= amount; i++){
        for(int j = 0; j <=coins.length; j++){
       arr[i][j]=(int)1e9;
        }
      }
      for(int i = 0; i <= coins.length; i++){
       arr[0][i]=0;
      }
      for(int i = 1; i <= amount; i++){
        for(int j = 1; j <=coins.length; j++){
            arr[i][j] = arr[i][j - 1];
            if(i -coins[j-1] >= 0){
                arr[i][j] = Math.min(arr[i][j], 1+ arr[i-coins[j-1]][j]);
            }
        }
      }

       return (arr[amount][coins.length]==(int)(1e9))?-1:arr[amount][coins.length]; 
    }

   
   
}
