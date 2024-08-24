class Solution {
    public void dfs(
        List<String> results, 
        Map<String, PriorityQueue<String>> fromToMap, 
        String from
    ) {
        // from -> to 값이 존재하는 경우 재귀 DFS
        while(fromToMap.containsKey(from) && !fromToMap.get(from).isEmpty()) {
            // 사전상 첫 위치부터 우선순위 큐를 이용해 목적지 추출, 재귀 DFS 진행
            dfs(results, fromToMap, fromToMap.get(from).poll());
        }

        // 재귀 DFS가 모두 끝나면 최종 도착지이므로, 여기서부터 출발지까지 앞으로 삽입한다.
        results.add(0, from);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        // LinkedList : 가장 앞에 원소를 추가할 때 시간복잡도가 O(1)
        List<String> results = new LinkedList();
        
        // from -> to map
        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();
        
        // 여행 일정 tickets로 그래프 구성
        for(List<String> ticket : tickets) {
            fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue());
            fromToMap.get(ticket.get(0)).add(ticket.get(1));
        }
        
        // 재귀 dfs 시작
        dfs(results, fromToMap, "JFK");
        
        return results;
    } 
}