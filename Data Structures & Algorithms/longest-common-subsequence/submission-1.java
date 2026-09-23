class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int arr[][] = new int[n+1][m+1];
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(text1.charAt(i)==text2.charAt(j)){
                    arr[i][j] = 1 + arr[i+1][j+1];
                }
                else
                {
                    arr[i][j] = Math.max(arr[i+1][j], arr[i][j+1]);
                }
            }
        }
        return arr[0][0];
    }

    public int dfs(int i, int j, String s, String t){
        if( i == s.length() || j == t.length())
        return 0;
        if(s.charAt(i)==t.charAt(j)){
           
           return 1+ dfs(i+1, j+1, s, t);

        }

        return Math.max(dfs(i+1,j, s, t ), dfs(i, j+1, s, t));
    }
}
