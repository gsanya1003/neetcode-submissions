class Solution {
    public int[] countBits(int n) {
        int arr[] = new int[n+1];
        for(int i = 1; i <= n; i++){
            int cnt = 0, t = i;
            while(t != 0 ){
                arr[i]++;
                t &= (t-1);

            }
        }
        return arr;
    }
}
