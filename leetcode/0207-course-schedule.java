class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 인접 그래프 생성
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] prerequisite : prerequisites) {
            List<Integer> preCourses = graph.getOrDefault(prerequisite[1], new ArrayList<>());
            preCourses.add(prerequisite[0]);
            graph.put(prerequisite[1], preCourses);
        }

        // 방문 기록 저장 - 0 : 미탐색, 1 : 탐색중, 2 : 탐색 완료
        int[] visited = new int[numCourses];

        // 그래프 탐색
        for(int course = 0; course < numCourses; course++) {
            if(!dfs(course, graph, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int index, Map<Integer, List<Integer>> graph, int[] visited) {
        // 선행 조건이 없을 경우 강의 수강 가능
        if(!graph.containsKey(index)) {
            return true;
        }

        // 이미 방문한 노드를 또 방문하는 경우 -> 순환 발생
        if(visited[index] == 1) {
            return false;
        }

        // 탐색 완료한 노드라면 추가 탐색하지 않는다.
        if(visited[index] == 2) {
            return true;
        }

        visited[index] = 1;
        List<Integer> preCourses = graph.get(index);
        for(int preCourse : preCourses) {
            // 이후 탐색 중에 순환이 발생하는 경우
            if(!dfs(preCourse, graph, visited)) {
                return false;
            }
        }

        visited[index] = 2;
        return true;
    }
}
