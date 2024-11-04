class Solution {
    private boolean dfs(Map<Integer,
                        List<Integer>> graph, Integer course,
                        List<Integer> takes,
                        List<Integer> taken) 
    {
        // 현재 수강해야하는 강의 번호가 이미 수강한 강의 목록에 있다면 순환 발생
        if(takes.contains(course)) {
            return false;
        }
        
        // 해당 강의 번호에 대해 여부를 검증했다면 더 이상 확인하지 않음
        if(taken.contains(course)) {
            return true;
        }
        
        // 현재 수강할 강의 번호(course)를 수강하려면 선수강해야하는 강의가 있다면
        if(graph.containsKey(course)) {
            takes.add(course);
            
            // 선수강 강의 목록들을 들을 수 있는지 확인
            for(Integer pre : graph.get(course)) {
                
                // 중간에 순환이 발생한다면 false
                if(!dfs(graph, pre, takes, taken)) {
                    return false;
                }
            }
            
            takes.remove(course);
            
            // true임이 검증된 노드 목록
            taken.add(course);
        }
        
        return true;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // key는 강의 번호, value는 해당 강의를 수강하기 위해 먼저 들어야하는 강의 목록을 map으로 나타낸다.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        // graph 초기화
        for(int[] pre : prerequisites) {
            List<Integer> value = graph.getOrDefault(pre[0], new ArrayList<>());
            value.add(pre[1]);
            graph.put(pre[0], value);
        }
        
        // 그래프 탐색
        
        // 현재까지 수강한 강의 목록
        List<Integer> takes = new ArrayList<>();
        
        // 검증이 완료된 강의 번호 목록
        List<Integer> taken = new ArrayList<>();
        for(Integer course : graph.keySet()) {
            if(!dfs(graph, course, takes, taken)){
                return false;
            }
        }
        
        return true;
    }
}