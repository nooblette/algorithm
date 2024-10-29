class Solution {
    int[][] heads = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    private void dfs(int rows, int cols, int cury, int curx, List<List<Integer>> path, int[][] heights) {
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
            if(path.contains(List.of(newy, newx))) {
                continue;
            }
                
            // 방문 경로에 추가
            path.add(List.of(newy, newx));
            
            // 새로운 노드에 대해 dfs 탐색
            dfs(rows, cols, newy, newx, path, heights);
        } 
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        // 초기화
        List<List<Integer>> defaultPacificList = new ArrayList<>();
        List<List<Integer>> pacificList = new ArrayList<>();
        for(int j = 0; j < cols; j++) {
            defaultPacificList.add(List.of(0, j));
            pacificList.add(List.of(0, j));
        }
    
        for(int i = 0; i < rows; i++) {
            defaultPacificList.add(List.of(i, 0));
            pacificList.add(List.of(i, 0));
        }
        
        // pacific에 도달할 수 있는 좌표 목록
        for(List<Integer> pacific : defaultPacificList) {
            // 현재 좌표
            int cury = pacific.get(0);
            int curx = pacific.get(1);
            
            dfs(rows, cols, cury, curx, pacificList, heights);
        }
        
        // 초기화
        List<List<Integer>> defaultAtlanticList = new ArrayList<>();
        List<List<Integer>> atlanticList = new ArrayList<>();
        for(int j = 0; j < cols; j++) {
            defaultAtlanticList.add(List.of(rows-1, j));
            atlanticList.add(List.of(rows-1, j));
        }
    
        for(int i = 0; i < rows; i++) {
            defaultAtlanticList.add(List.of(i, cols-1));
            atlanticList.add(List.of(i, cols-1));
        }
        
        // atlantic 도달할 수 있는 좌표 목록
        for(List<Integer> atlantic : defaultAtlanticList) {
            // 현재 좌표
            int cury = atlantic.get(0);
            int curx = atlantic.get(1);
            
            dfs(rows, cols, cury, curx, atlanticList, heights);
        }
        
        // 두 바다에 도달할 수 있는 공통 원소 탐색
        Set<List<Integer>> answer = new HashSet<>();
        for(List<Integer> pacific : pacificList) {
            if(atlanticList.contains(pacific)) {
                answer.add(pacific);
            }
        }
        
        return new ArrayList<>(answer);
    }
}