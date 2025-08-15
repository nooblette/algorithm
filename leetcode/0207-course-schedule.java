class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 인접 그래프(graph.get(i) = i번 강의를 선수강 조건으로 갖는 강의 목록)
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // 진입차수(선수강 강의 개수) 기록
        int[] indegrees = new int[numCourses];

        // 인접 그래프와 진입차수 초기화
        for(int[] prerequisite : prerequisites) {
            // 인접 그래프 초기화
            List<Integer> preCourses = graph.getOrDefault(prerequisite[1], new ArrayList<>());
            preCourses.add(prerequisite[0]);
            graph.put(prerequisite[1], preCourses);

            // 진입차수 증가
            indegrees[prerequisite[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < indegrees.length; i++) {
            // 먼저 들을 수 있는(= 선수강 조건이 없는) 강의 먼저 수강한다.
            if(indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        // 수강한 강의 개수
        int processed = 0;
        while(!queue.isEmpty()) {
            // i번 강의 수강 완료
            int i = queue.poll();
            processed++;

            // 선수강 조건 중 i번 강의가 있는 강의에 진입차수를 1 감소한다.
            if(graph.containsKey(i)) {
                for(int course : graph.get(i)) {
                    indegrees[course]--;

                    // 선수강 강의를 모두 들었다면 큐에 추가
                    if(indegrees[course] == 0) {
                        queue.offer(course);
                    }
                }
            }
        }

        // 모든 강의 수강 여부 반환
        return processed == numCourses;
    }
}
