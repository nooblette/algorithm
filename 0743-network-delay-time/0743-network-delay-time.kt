import java.util.AbstractMap

class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        // 네트워크의 각 노드를 출발지 -> 도착지 형태로 그래프 구성
        val graph: MutableMap<Int, MutableMap<Int, Int>> = mutableMapOf()
        for(time in times) {
            // 값이 존재하지 않을 경우 빈 해시맵 생성
            graph.putIfAbsent(time[0], mutableMapOf())
            
            // 출발지에 {도착지, 가중치} 추가
            graph[time[0]]!![time[1]] = time[2]
        }
        
        // 도착지까지 소요 시간을 기준으로 오름차순 정렬하는 우선순위 큐 구현
        // 우선순위 큐의 원소를 간단하게 순회하기 위해 Map 대신에 Map.Entry로 구현
        val pq: PriorityQueue<Map.Entry<Int, Int>> = PriorityQueue(compareBy { (node, time) -> time })
        
        // 시작은 출발지 k, 출발지 -> 출발지 이므로 가중치는 0이다.
        pq.add(AbstractMap.SimpleEntry(k, 0))
        
        // 가중치 계산 - {도착지, 소요시간} 최종 결과를 저장하는 변수
        val dist: MutableMap<Int, Int> = mutableMapOf()
        
        // 큐에 값이 남아있다면 없어질때까지 반복
        while(!pq.isEmpty()) {
            // 소요 시간이 가장 빠른 값 추출
            val (u, w) = pq.poll()
            
            // u 지점까지의 소요시간이 아직 계산되지 않았다면 가중치 계산 시작
            // 우선순위 큐에서 항상 가중치가 최소인 값만을 꺼내어 dist에 추가한다. -> 즉 dist는 항상 최소값임을 보장할 수 있다.
            // 따라서 목적지 u에 대한 가중치 dist를 이미 구했다면? 이는 이미 최단 경로이므로 dist에 추가하지 않는다.
            if(!dist.containsKey(u)) {
                // u지점까지의 가중치 w를 dist에 추가
                dist[u] = w
                
                // u 지점을 출발지로 하는 경로가 있다면 처리
                if(graph.containsKey(u)) {
                    // u 지점을 출발지로 하는 모든 경로 순회
                    for((v, weight_u_v) in graph[u]!!) {
                        // w(= 출발지에서 u까지의 가중치) + v.getValue(u에서 목적지까지의 가중치) 계산
                        val alt = w + weight_u_v

                        // 우선순위 큐에 (도착지, 출발지 -> u -> 목적지 소요 시간) 삽입
                        pq.add(AbstractMap.SimpleEntry(v, alt))
                    }
                }
            }
        }
        
        return if(dist.size == n) 
            Collections.max(dist.values)
        else 
            -1
    }
}