class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    int cntOnes(int[][] Grid) {
        int n = Grid.length, m = Grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && Grid[i][j] == 1)
                    dfs(Grid, i, j);
            }
        }

        int cnt = 0;
        for (int[] r : Grid)
            for (int x : r)
                if (x == 1) cnt++;

        return cnt;
    }

    void dfs(int[][] Grid, int x, int y) {
        int n = Grid.length, m = Grid[0].length;
        if (x < 0 || y < 0 || x >= n || y >= m || Grid[x][y] != 1)
            return;

        Grid[x][y] = -1;
        for (int k = 0; k < 4; k++)
            dfs(Grid, x + dr[k], y + dc[k]);
    }
}
