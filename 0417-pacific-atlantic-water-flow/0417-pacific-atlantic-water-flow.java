class Solution {
    int[][] heads = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    private void dfs(int rows, int cols, int cury, int curx, boolean[][] visited, int[][] heights) {
        // 방문 경로에 추가
        visited[cury][curx] = true;
        
        // 도달할 수 있는 좌표 목록 탐색
        for(int[] head : heads) {
            int newy = cury + head[0];
            int newx = curx + head[1];
                
            // 이동할 수 없는 경로
            if(newy < 0 || newx < 0 || newy >= rows || newx >= cols) {
                continue;
            }
                
            // 새로운 방향이 현재 sea level보다 작다면 도달 불가
            if(heights[cury][curx] > heights[newy][newx]) {
                continue;
            }
                
            // 이미 방문한 노드는 방문 불가
            if(visited[newy][newx]) {
                continue;
            } 
            
            // 새로운 노드에 대해 dfs 탐색
            dfs(rows, cols, newy, newx, visited, heights);
        } 
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        // 방문 경로 저장
        boolean[][] pacificVisited = new boolean[rows][cols];
        boolean[][] atlanticVisited = new boolean[rows][cols];
        
        for(int j = 0; j < cols; j++) {
            // 태평양 도달 가능 위치에 대해 dfs 탐색
            dfs(rows, cols, 0, j, pacificVisited, heights);
            
            // 대서양 도달 가능 위치에 대해 dfs 탐색
            dfs(rows, cols, rows-1, j, atlanticVisited, heights);
        }
    
        for(int i = 0; i < rows; i++) {
             // 태평양 도달 가능 위치에 대해 dfs 탐색
            dfs(rows, cols, i, 0, pacificVisited, heights);
            
            // 대서양 도달 가능 위치에 대해 dfs 탐색
            dfs(rows, cols, i, cols-1, atlanticVisited, heights);
        }
        
        // 두 바다에 도달할 수 있는 공통 원소 탐색
        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(pacificVisited[i][j] && atlanticVisited[i][j]) {
                    answer.add(List.of(i, j));
                }
            }
        }
        
        return answer;
    }
}