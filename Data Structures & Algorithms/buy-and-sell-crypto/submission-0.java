class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int i = 0, j = 0, max = 0, curr = 0;
        while( j < n){
            if(prices[j]-prices[i] < 0){
                i = j;
               // j++;
                
               
            }
            else
            {
                max = Math.max(max, prices[j]-prices[i]);
                j++;
            }
        }
        return max;
    }
}
