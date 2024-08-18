class Solution {
    data class Point(
        var distance: Long,
        var point: IntArray
    )
    
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        // Point를 원소로 하고, 두 점 사이의 거리를 정렬 기준으로 갖는 오는 우선순위 큐 선언
        val pq: Queue<Point> = PriorityQueue(compareBy {a -> a.distance})
        
        // 파라미터로 받은 좌표 목록 조회
        for(point in points) {
            // 유클리드 거리 계산
            val distance = point[0].toLong() * point[0] + point[1].toLong() * point[1]
            
            // 우선순위 큐에 거리와 좌표를 Point 클래스로 삽입
            pq.add(Point(distance, point))
        }
        
        // 결과 변수 선언
        val results: Array<IntArray> = Array(k) {IntArray(2) {0}}
        
        // 우선순위 큐에서 distance가 가장 작은 k개의 좌표만 추출
        for(i in 0 until k) {
            results[i] = pq.poll().point
        }
        
        return results
    }
}