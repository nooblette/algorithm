
import java.util.*

class Solution {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        val fromToMap: MutableMap<String, PriorityQueue<String>> = mutableMapOf()
        
        // 여행 일정을 위해 from -> to 그래프 구성
        for(ticket in tickets) {
            // 값이 존재하지 않을 경우 빈 우선순위 큐 먼저 생성
            fromToMap.putIfAbsent(ticket[0], PriorityQueue())

            // 우선순위 큐에 경로 추가, 항상 사전 어휘순으로 오름차순 정렬된다.
            fromToMap[ticket[0]]!!.add(ticket[1])
        }
        
        val results: MutableList<String> = LinkedList()
        val stack: Deque<String> = LinkedList()
        
        // 출발지 삽입
        stack.push("ICN")
        while(!stack.isEmpty()) {
            // 스택에서 추출될 값을 출발지로 한 도착지 처리
            while(fromToMap.containsKey(stack.first) && !fromToMap[stack.first]!!.isEmpty()) {
                // 사전 어휘순으로 도착지 출력
                stack.push(fromToMap[stack.first]!!.poll())
            }
            
            // stack의 top부터 값을 추출하여 정답 구성
            results.add(0, stack.pop())
        }
        return results.toTypedArray()
    }
}