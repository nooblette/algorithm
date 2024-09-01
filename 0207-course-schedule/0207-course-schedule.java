class Solution {
    public boolean dfs(Map<Integer, List<Integer>> finishToTakeMap, Integer finish, List<Integer> takes, List<Integer> taken) {
        // 현재 수강해야하는 강의 번호 finish가 이미 수강한 강의 목록 takes에 포함되는지 검사
        if(takes.contains(finish)) {
            return false;
        }
        
        // 가지치기를 이용한 최적화, 이미 true임을 검증했다면 더이상 탐색하지 않는다.
        if(taken.contains(finish)) {
            return true;
        }

        // 현재 수강해야하는 강의 번호에 먼저 수강해야하는 강의 목록이 있다면
        if(finishToTakeMap.containsKey(finish)) {
            // 먼저 수강한 강의 목록에 추가(방문한 노드 경로에 추가)
            takes.add(finish);

            for(Integer take : finishToTakeMap.get(finish)) {
                if(!dfs(finishToTakeMap, take, takes, taken)) {
                    return false;
                }
            }

            // 탐색 후 방문한 노드 경로 제거
            takes.remove(finish);
            
            // true임을 검증했다면 최적화를 위해 검증 완료된 노드 목록에 추가한다.
		    taken.add(finish);
        }

        // 코스에 문제가 없으므로 true 반환
        return true;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 특정 강의를 수강하기 위해 먼저 수강해야하는 강의 목록을 finish -> take 형태의 그래프로 구성
        Map<Integer, List<Integer>> finishToTakeMap = new HashMap<>();
        for(int[] pre : prerequisites) {
            // 값이 존재하기 않을 경우 빈 리스트 생성
            finishToTakeMap.putIfAbsent(pre[0], new ArrayList<>());

            // 처리해야하는 강의 목록 추가
            finishToTakeMap.get(pre[0]).add(pre[1]);
        }
        
        // 그래프 탐색
        List<Integer> takes = new ArrayList<>();
        List<Integer> taken = new ArrayList<>();
        for(Integer finish : finishToTakeMap.keySet()) {
            if(!dfs(finishToTakeMap, finish, takes, taken)) {
                return false;
            }
        }
                   
        return true;
    }
}