import java.util.*;

class Solution {
    // 우선순위 큐의 원소
    static class Position {
        final int y;
        final int x;
        final int distance;

        public Position(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }

    // Position의 거리(distance)를 기준으로 오름차순 정렬하는 우선순위 큐 선언
    Queue<Position> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance)); 
    
    public void findPath(int y, int x, int distance, int[][] maps) {
        // 게임 맵 내에 위치하면서
        if(y >= 0 && y < maps.length && x >= 0 && x < maps[0].length && maps[y][x] != 0) {
            // 이미 지나온 경로는 더 이상 거치지 않도록 기록
            maps[y][x] = 0;

            // 현재 위치와 거리 + 1을 우선순위 큐에 삽입
            pq.add(new Position(y, x, distance + 1));
        }
    }
    
    public int solution(int[][] maps) {
        // 우선순위 큐에 출발지 삽입
        pq.add(new Position(0, 0, 1));
        
        while(!pq.isEmpty()) {
            // 거리가 가장 짧은 원소 추출
            Position cur = pq.poll();
            
            // 상대팀 진영에 도달했다면 탐색 종료
            if(cur.y + 1 == maps.length && cur.x + 1 == maps[0].length) {
                return cur.distance;
            }
                
            // 동서남북 탐색
            findPath(cur.y, cur.x + 1, cur.distance, maps); // 동
            findPath(cur.y, cur.x - 1, cur.distance, maps); // 서
            findPath(cur.y + 1, cur.x, cur.distance, maps); // 남
            findPath(cur.y - 1, cur.x, cur.distance, maps); // 북
        }
            
        // 상대팀 진영에 도달할 수 없는 경우
        return -1;
    }
}