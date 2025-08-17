class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int result = 0;

        // 방문 기록 저장
        boolean[][] visited = new boolean[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == '0' || visited[i][j] == true) {
                    continue;
                }
                // 탐색 시작 지점만큼 증가
                result++;
                dfs(i, j, grid, visited, r, c);
            }
        }

        return result;
    }

    private void dfs(int curR, int curC, char[][] grid, boolean[][] visited, int r, int c) {
        if(curR < 0 || curR >= r || curC < 0 || curC >= c || grid[curR][curC] == '0' || visited[curR][curC] == true) {
            return;
        }

        // 방문 기록 저장
        visited[curR][curC] = true;

        // 상하좌우
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int[] direction : directions) {
            int newR = curR + direction[0];
            int newC = curC + direction[1];
            dfs(newR, newC, grid, visited, r, c);
        }

    }
}
