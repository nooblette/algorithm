class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        // 배열 초기화 - dist[i] = src에서 i까지 방문하는데 필요한 비용
        var dist = IntArray(n) {Integer.MAX_VALUE}
        
        // 가중치 배열 초기화
        dist[src] = 0
        
        // k번 경유 횟수를 제한하여 loop
        for(i in 0..k) {
            // 현재 단계에서 업데이트를 위한 복사본을 생성(기존 dist에 영향을 주지 않기 위해 깊은 복사)
            val temp = dist.copyOf()
            
            for(flight in flights) {
                val u = flight[0]
                val v = flight[1]
                val w = flight[2]
                
                // src -> u까지 가는 경로가 있으면서, u를 경유하는 비용이 더 저렴한 경우 src -> v를 갱신
                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < temp[v]) {
                    temp[v] = dist[u] + w
                }
            }
            
            // dist에 경유 횟수에 따른 비용 업데이트
            dist = temp
        }
        
        return if(dist[dst] == Integer.MAX_VALUE)
            -1 // k번 경유하고 dst를 방문할 수 없는 경우
        else
            dist[dst]
    }
}