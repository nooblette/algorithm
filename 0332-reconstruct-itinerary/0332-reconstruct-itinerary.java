class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();
        
        // 여행 일정을 위해 from -> to 그래프 구성
        for(List<String> ticket : tickets) {
            // 값이 존재하지 않을 경우 빈 우선순위 큐 먼저 생성
            fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());

            // 우선순위 큐에 경로 추가, 항상 사전 어휘순으로 오름차순 정렬된다.
            fromToMap.get(ticket.get(0)).add(ticket.get(1));
        }
        
        List<String> results = new LinkedList();
        Deque<String> stack = new ArrayDeque<>();
        // 출발지 삽입
        stack.push("JFK");
        while(!stack.isEmpty()) {
            // 스택에서 추출될 값을 출발지로 한 도착지 처리
            while(fromToMap.containsKey(stack.getFirst()) && !fromToMap.get(stack.getFirst()).isEmpty()) {
                // 사전 어휘순으로 도착지 출력
                stack.push(fromToMap.get(stack.getFirst()).poll());
            }
            
            // stack의 top부터 값을 추출하여 정답 구성
            results.add(0, stack.pop());
        }
        
        return results;
    }
}