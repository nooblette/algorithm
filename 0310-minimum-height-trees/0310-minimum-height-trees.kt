class Solution {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        // 예외 처리
        if(n == 1) {
            return listOf(0)
        }
        
        // 주어진 edges로 출발 노드 -> 도착 노드 목록을 구성하는 Map 구현
        val graph: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        for(edge in edges) {
            // 값이 존재하지 않을 경우 빈 리스트 먼저 생성
            graph.putIfAbsent(edge[0], mutableListOf());
            graph.putIfAbsent(edge[1], mutableListOf());

            // 그래프 구성
            graph[edge[0]]!!.add(edge[1]);
            graph[edge[1]]!!.add(edge[0]);
        }
        
        // 리프 노드 목록 저장
        var leaves: MutableList<Int> = mutableListOf()
        for(i in 0 until n) {
            // 연결이 하나인 노드를 리프 노드 목록에 추가
            if(graph[i]!!.size == 1) {
                leaves.add(i)
            }
        }
        
        // 남은 리프 노드 개수, 초깃값은 전체 노드 수 n
        var left = n
        
        // 루트 노드만 남을때 까지 반복
        while(left > 2) {
            // 이전 단계 리프 노드 개수만큼 n에서 제거
            left -= leaves.size
            
            // 단계별 새로운 리프 노드 목록 저장
            val newLeaves: MutableList<Int> = mutableListOf()
            for(leaf in leaves) {
                // 리프 노드의 이웃 노드 추출
                val neighbor = graph[leaf]!![0]
                
                // 그래프에서 리프 노드와 연결된 경우 해당 연결 제거
                graph[neighbor]!!.remove(leaf)
                
                // 이웃 노드가 리프 노드가 된 경우 새로운 리프 노드 목록에 저장
                if(graph[neighbor]!!.size == 1) {
                    newLeaves.add(neighbor)
                }
            }

            // 리프 노드 목록 리스트 갱신
            leaves = newLeaves
        }
        
        // 노드가 2개 이하 남게 될 때 최종 결과 리턴
        return leaves
    }
}