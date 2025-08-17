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
                bfs(i, j, grid, r, c);
            }
        }

        return result;
    }

    private void bfs(int startR, int startC, char[][] grid, int r, int c) {
        Deque<List<Integer>> queue = new ArrayDeque<>();

        // 방문한 섬은 물로 변경한다.
        grid[startR][startC] = '0';
        queue.offer(List.of(startR, startC));

        // BFS
        while(!queue.isEmpty()) {
            List<Integer> cur = queue.poll();
            int curR = cur.get(0);
            int curC = cur.get(1);

            // 상하좌우
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            // 탐색
            for(int[] direction : directions) {
                int newR = curR + direction[0];
                int newC = curC + direction[1];

                if(newR < 0 || newR >= r || newC < 0 || newC >= c || grid[newR][newC] == '0') {
                    continue;
                }

                // 방문한 섬은 물로 변경한다.
                grid[newR][newC] = '0';
                queue.offer(List.of(newR, newC));
            }
        }
    }
}
