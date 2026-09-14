class Pair {
    int r;
    int c;

    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] he) {

        int n = he.length;
        int m = he[0].length;

        int[][] vis = new int[n][m];
        int[][] visa = new int[n][m];

        Queue<Pair> pq = new LinkedList<>();
        Queue<Pair> aq = new LinkedList<>();

        List<List<Integer>> res = new ArrayList<>();

        // ---------------- PACIFIC ----------------

        // Top row
        for (int j = 0; j < m; j++) {
            pq.add(new Pair(0, j));
            vis[0][j] = 1;
        }

        // Left column
        for (int i = 1; i < n; i++) {
            pq.add(new Pair(i, 0));
            vis[i][0] = 1;
        }

        while (!pq.isEmpty()) {

            Pair p = pq.remove();

            int r = p.r;
            int c = p.c;

            // DOWN
            if (r < n - 1 &&
                he[r][c] <= he[r + 1][c] &&
                vis[r + 1][c] == 0) {

                vis[r + 1][c] = 1;
                pq.add(new Pair(r + 1, c));
            }

            // UP
            if (r > 0 &&
                he[r][c] <= he[r - 1][c] &&
                vis[r - 1][c] == 0) {

                vis[r - 1][c] = 1;
                pq.add(new Pair(r - 1, c));
            }

            // RIGHT
            if (c < m - 1 &&
                he[r][c] <= he[r][c + 1] &&
                vis[r][c + 1] == 0) {

                vis[r][c + 1] = 1;
                pq.add(new Pair(r, c + 1));
            }

            // LEFT
            if (c > 0 &&
                he[r][c] <= he[r][c - 1] &&
                vis[r][c - 1] == 0) {

                vis[r][c - 1] = 1;
                pq.add(new Pair(r, c - 1));
            }
        }

        // ---------------- ATLANTIC ----------------

        // Bottom row
        for (int j = 0; j < m; j++) {
            aq.add(new Pair(n - 1, j));
            visa[n - 1][j] = 1;
        }

        // Right column
        for (int i = 0; i < n - 1; i++) {
            aq.add(new Pair(i, m - 1));
            visa[i][m - 1] = 1;
        }

        while (!aq.isEmpty()) {

            Pair p = aq.remove();

            int r = p.r;
            int c = p.c;

            // UP
            if (r > 0 &&
                he[r][c] <= he[r - 1][c] &&
                visa[r - 1][c] == 0) {

                visa[r - 1][c] = 1;
                aq.add(new Pair(r - 1, c));
            }

            // DOWN
            if (r < n - 1 &&
                he[r][c] <= he[r + 1][c] &&
                visa[r + 1][c] == 0) {

                visa[r + 1][c] = 1;
                aq.add(new Pair(r + 1, c));
            }

            // LEFT
            if (c > 0 &&
                he[r][c] <= he[r][c - 1] &&
                visa[r][c - 1] == 0) {

                visa[r][c - 1] = 1;
                aq.add(new Pair(r, c - 1));
            }

            // RIGHT
            if (c < m - 1 &&
                he[r][c] <= he[r][c + 1] &&
                visa[r][c + 1] == 0) {

                visa[r][c + 1] = 1;
                aq.add(new Pair(r, c + 1));
            }
        }

        // ---------------- RESULT ----------------

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (vis[i][j] == 1 && visa[i][j] == 1) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }
}