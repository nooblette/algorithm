class Solution {
    int[][] heads = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    
    private int dfs(int m, int n, int y, int x, boolean[][] visited, char[][] grid) {
        if(y < 0 || x < 0 || y >= m || x >= n) {
            return 0;
        }
        
        if(visited[y][x]) {
            return 0;
        }
        
        if(grid[y][x] == '0') {
            return 0;
        }
        
        visited[y][x] = true;
        int answer = 1;
        for(int[] head : heads) {
            int newy = y + head[0];
            int newx = x + head[1];
            
            answer += dfs(m, n, newy, newx, visited, grid);
        }
        
        return answer;
    }
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // 방문 경로를 저장하기 위한 배열
        boolean[][] visited = new boolean[m][n];
        
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dfs(m, n, i, j, visited, grid) > 0) {
                    count += 1;
                }
            }
        }
        
        return count;
    }
}