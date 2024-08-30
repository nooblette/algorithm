import java.util.*;

class Solution {
    public void dfs(List<String> answer, 
                    Map<String, PriorityQueue<String>> pq, 
                    String from) {

        while(pq.containsKey(from) && !pq.get(from).isEmpty()){
            dfs(answer, pq, pq.get(from).poll());
        }
        
        // 경로에 방문한 공항을 역순으로 추가
        answer.add(0, from);
    }
    
    public String[] solution(String[][] tickets) {
        // fromToMap 선언
        Map<String, PriorityQueue<String>> pq = new HashMap<>();
        for(String[] ticket : tickets) {
            // 목적지 목록 (value) 조회
            PriorityQueue<String> destinations
                = pq.getOrDefault(ticket[0], new PriorityQueue<String>());
            
            // 목적지 추가
            destinations.add(ticket[1]);
            
            // 목적지를 추가하여 pq 업데이트
            pq.put(ticket[0], destinations);
        }
        
        // dfs 탐색
        List<String> answer = new ArrayList<>();
        dfs(answer, pq, "ICN");
        
        return answer.toArray(new String[0]);
    }
}