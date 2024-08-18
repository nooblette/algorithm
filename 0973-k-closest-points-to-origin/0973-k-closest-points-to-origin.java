class Solution {
    // 좌표와 원점으로부터의 거리(distance)를 갖는 Point 클래스 선언
    static class Point {
        double distance;
        int[] point;
        
        public Point(double distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        // Point를 원소로 갖으면서 두 점 사이의 거리가 작은 값이 먼저 오는 우선순위 큐 선언
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.distance));
        
        // 파라미터로 받은 좌표 목록 순회
        for(int[] point : points) {
            // 유클리드 거리 계산
            double distance = Math.sqrt((long) point[0] * point[0] + (long) point[1] * point[1]);
            
            // 우선순위 큐에 추가
            pq.add(new Point(distance, point));
        }
        
        // 우선순위 큐에서 distance가 가장 작은 k개의 좌표만 추출
        int[][] results = new int[k][];
        for(int i = 0; i < k; i++) {
            results[i] = pq.poll().point;
        }
        
        return results;
    }
}