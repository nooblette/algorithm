class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;

        // pacific ocean에서 시작해서 도달 가능한 cell을 기록
        boolean[][] pacific = new boolean[r][c];

        // atlantic ocean에서 시작해서 도달 가능한 cell을 기록
        boolean[][] atlantic = new boolean[r][c];

        for(int i = 0; i < c; i++) {
            dfs(0, i, pacific, heights, heights[0][i]); // Pacific 상단
            dfs(r-1, i, atlantic, heights, heights[r-1][i]); // Atlantic 하단
        }

        for(int i = 0; i < r; i++) {
            dfs(i, 0, pacific, heights, heights[i][0]); // Pacific 좌측
            dfs(i, c-1, atlantic, heights, heights[i][c-1]); // Atlantic 우측
        }

        // 두 Ocean에 모두 도달 가능한 cell의 목록을 찾고 반환
        List<List<Integer>> results = new ArrayList<>();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    results.add(List.of(i, j));
                }
            }
        }

        return results;
    }

    private void dfs(int r, int c, boolean[][] visited, int[][] heights, int prevHeights) {
        // 범위를 벗어난 경우
        if(r < 0 || r >= heights.length || c < 0 || c >= heights[0].length) {
            return;
        } 

        // 물이 이동할 수 없는 경우
        if(prevHeights > heights[r][c]) {
            return;
        }

        // 이미 방문한 경우
        if(visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        // 상하좌우
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for(int[] direction : directions) {
            dfs(r + direction[0], c + direction[1], visited, heights, heights[r][c]);
        }
    }
}
