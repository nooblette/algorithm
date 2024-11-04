class Solution {
    int[][] heads = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // 섬의 시작 지점인 경우 
                if(grid[i][j] == '1') {
                    count++;
                    
                    // bfs 탐색을 위함
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    
                    // 방문 처리
                    grid[i][j] = '0';
                    
                    // BFS 탐색
                    while(!queue.isEmpty()) {
                        int[] pos = queue.poll();
                        int x = pos[1];
                        int y = pos[0];
                        
                        for(int[] head : heads) {
                            int newx = x + head[1];
                            int newy = y + head[0];
                            
                            // 인접한 땅을 큐에 추가하고 방문 처리
                            if(newy >= 0 && newx >= 0 && newy < m && newx < n && grid[newy][newx] == '1') {
                                queue.add(new int[]{newy, newx});
                                grid[newy][newx] = '0';
                            }
                        }
                    }
                }
            }
        }
        
        return count;
    }
}