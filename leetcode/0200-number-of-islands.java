class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int result = 0;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == '0') {
                    continue;
                }
                // 탐색 시작 지점만큼 증가
                result++;
                dfs(i, j, grid, r, c);
            }
        }

        return result;
    }

    private void dfs(int curR, int curC, char[][] grid, int r, int c) {
        if(curR < 0 || curR >= r || curC < 0 || curC >= c || grid[curR][curC] == '0') {
            return;
        }

        // 방문한 섬은 물로 변경한다.
        grid[curR][curC] = '0';

        // 상하좌우
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int[] direction : directions) {
            int newR = curR + direction[0];
            int newC = curC + direction[1];
            dfs(newR, newC, grid, r, c);
        }
    }
}
