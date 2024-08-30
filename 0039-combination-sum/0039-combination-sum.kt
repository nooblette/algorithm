class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        // 결과 저장 리스트 선언
        val results: MutableList<List<Int>> = mutableListOf()
        
        fun dfs(target: Int, index: Int, path: Deque<Int>) {
            // 0보다 작다면 목표값을 넘었으므로 리턴
            if(target < 0) {
                return
            }
            
            // 0이면 목표값에 도달했으므로 path를 결과에 삽입
            if(target == 0) {
                results.add(path.toList())
                return
            }
            
            // 자기 자신과 같거나 큰 숫자에 대해 dfs 진행
            for (i in index until candidates.size) {
                // path에 현재 엘리먼트 추가
                path.add(candidates[i])
                
                // 재귀 dfs
                dfs(target - candidates[i], i, path)
                path.removeLast()
            }
        }
            
        // dfs 탐색
        dfs(target, 0, LinkedList())
        return results
    }
}