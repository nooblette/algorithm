class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        // 특정 강의를 수강하기 위해 먼저 수강해야하는 강의 목록을 finish -> take 형태의 그래프로 구성
        
        // 그래프 구성
        val finishToTakeMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        for(pre in prerequisites) {
            // 값이 존재하지 않을 경우 빈 리스트 생성
            finishToTakeMap.putIfAbsent(pre[0], mutableListOf())
            
            // 처리해야하는 강의 목록 추가
            finishToTakeMap[pre[0]]!!.add(pre[1])
        }
        
        // 특정 강의를 수강하기 전까지 먼저 수강해야하는 강의 목록(즉 방문한 노드 목록)을 저장
        val takes: MutableList<Int> = mutableListOf()
        
        // 검증이 완료된 강의 번호 목록을 저장
        val taken: MutableList<Int> = mutableListOf()
        
        fun dfs(finish: Int, takes: MutableList<Int>, taken: MutableList<Int>): Boolean {
            // 현재 수강해야하는 강의 번호 finish가 이미 수강한 강의 목록 takes에 포함되는지 검사
            if(takes.contains(finish)) {
                return false
            }
            
            // 가지치기를 이용한 최적화, 이미 true임을 검증했다면 더이상 탐색하지 않는다.
            if(taken.contains(finish)) {
                return true
            }
            
            // 현재 수강해야하는 강의 번호에 먼저 수강해야하는 강의 목록이 있다면
            if(finishToTakeMap.containsKey(finish)) {
                // 먼저 수강한 강의 목록에 추가(방문한 노드 경로에 추가)
                takes.add(finish)
                
                for(take in finishToTakeMap[finish]!!) {
                    if(!dfs(take, takes, taken)) {
                        return false
                    }
                }

                // 탐색 후 방문한 노드 경로 제거
                takes.remove(finish)

                // true임을 검증했다면 최적화를 위해 검증 완료된 노드 목록에 추가한다.
                taken.add(finish)
            }
            
            return true
        }
        
        // 그래프 탐색
        for(finish in finishToTakeMap.keys) {
            if(!dfs(finish, takes, taken)) {
                return false
            }
        }
        
        return true
    }
}