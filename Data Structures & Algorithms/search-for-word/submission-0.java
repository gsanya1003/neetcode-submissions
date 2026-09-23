class Solution {
    public boolean exist(char[][] brr, String s) {
        int n = brr.length;
        int m = brr[0].length;
        int vist[][] = new int[n][m];

        // Must start search from every cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis(brr, s, n, m, i, j, "", vist)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean vis(char brr[][], String s, int n, int m, int i, int j, String t, int vist[][]) {
        if (i >= n || j >= m || i < 0 || j < 0) return false;
        if (vist[i][j] == 1) return false;

        String currentStr = t + brr[i][j];

        // Check if string comparison matches
        if (currentStr.equals(s)) return true;
        
        // Stop early if current path doesn't match prefix of target string
        if (!s.startsWith(currentStr)) return false;

        vist[i][j] = 1;

        // Propagate 'true' up if any path succeeds
        if (vis(brr, s, n, m, i - 1, j, currentStr, vist) ||
            vis(brr, s, n, m, i + 1, j, currentStr, vist) ||
            vis(brr, s, n, m, i, j - 1, currentStr, vist) ||
            vis(brr, s, n, m, i, j + 1, currentStr, vist)) {
            return true;
        }

        vist[i][j] = 0; // Backtrack
        return false;
    }
}