class Solution {
    
    fun numIslands(grid: Array<CharArray>): Int {
        fun dfs(i: Int, j: Int) {
            // 현재 위치가 그리드 밖이거나 물(0)인 경우 탐색 종료
            when {
                (i < 0) ||
                (i >= grid.size) ||
                (j < 0) ||
                (j >= grid[0].size) ||
                (grid[i][j] == '0') -> return
            }
            
            // 방문 지점 마킹
            grid[i][j] = '0'
            
            // dfs 탐색
            dfs(i, j+1)
            dfs(i, j-1)
            dfs(i+1, j)
            dfs(i-1, j)
        }
        
        var count = 0
        for(i in grid.indices) {
            for(j in grid[i].indices) {
                // 육지(1)인 경우 dfs 탐색 시작
                if(grid[i][j] == '1') {
                    dfs(i, j)
                    
                    // dfs 탐색이 끝나면 섬 하나를 찾았으므로 카운트를 1만큼 증가
                    count++
                }
            }
        }
        
        // 섬의 개수 반환
        return count
        
    }
}