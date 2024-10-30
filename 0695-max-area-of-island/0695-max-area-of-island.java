class Solution {
    int[][] heads = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    int answer = 0;
    
    private int dfs(int cury, int curx, boolean[][] visited, int[][] grid, int cols, int rows) {
        // 지정한 범위를 넘어가는 경우
        if(cury < 0 || curx < 0 || cury >= rows || curx >= cols) {
            return 0;
        }
        
        // 이미 방문한 경로인 경우
        if(visited[cury][curx]) {
            return 0;
        }
        
        // 새로운 위치가 물인 경우 탐색하지 않는다.
        if(grid[cury][curx] == 0) {
            return 0;
        }
            
        int area = 1;
        visited[cury][curx] = true;
        for(int[] head : heads) {
            int newy = cury + head[0];
            int newx = curx + head[1];
            
            area += dfs(newy, newx, visited, grid, cols, rows);
        }
        
        return area;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int cols = grid[0].length;
        int rows = grid.length;
        
        // 방문한 위치를 저장
        boolean[][] visited = new boolean[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                // 물인 경우
                if(grid[i][j] == 0) continue;
                
                // 이미 탐색한 노드인 경우
                if(visited[i][j]) continue;
                
                int area = dfs(i, j, visited, grid, cols, rows);
                
                answer = Math.max(answer, area);
            }
        }
        
        return answer;
    }
}