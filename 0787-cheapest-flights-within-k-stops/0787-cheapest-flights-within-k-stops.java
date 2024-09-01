class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 배열 초기화 - dist[i] = src에서 i까지 방문하는데 필요한 비용
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // 가중치 배열 초기화
        dist[src] = 0;
                
        // k번 경유 횟수를 제한하여 loop
        for(int i = 0; i <= k; i++) {
            // 현재 단계에서의 업데이트를 위한 복사본을 생성
            int[] temp = Arrays.copyOf(dist, n);
            
            for(int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];
                
                // 현재까지 탐색한 경로중 u까지 가는 경로가 있으면서 v를 경유하는 비용이 더 저렴한 경우
                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < temp[v]) {
                    // 비용 갱신
                    temp[v] = dist[u] + w;
                }
            }
            
            // dist에 경유 횟수에 따른 비용 업데이트
            dist = temp;
        }
        
        
        // k번 경유하고 dst를 방문할 수 없는 경우
        if(dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        
        return dist[dst];
    }
}