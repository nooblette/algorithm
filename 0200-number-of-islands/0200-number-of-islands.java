class Solution {
    private void dfs(int i, int j, char[][] grid) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        // 이미 방문한 곳을 마킹
        grid[i][j] = '0';

        // 동서남북 탐색
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
    }
           
    public int numIslands(char[][] grid) {
        int count = 0;
        
        // grid 탐색
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                // 육지인 경우
                if(grid[i][j] == '1') {
                    dfs(i, j, grid);
                    
                    // dfs 탐색이 모두 끝나면 섬 하나가 완성되므로 카운트 증가
                    count++;
                }
            }
        }
        
        // 섬의 개수 반환
        return count;
    }
}