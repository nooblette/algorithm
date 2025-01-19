class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        // 우선순위 큐 선언, 자바 기본은 최소 힙이므로 최대 힙으로 정렬 지정
        val pq: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())

        // 입력 값을 모두 힙에 삽입
        for(num in nums)
            pq.add(num)

        // k - 1만컴 힙에서 추출
        for(i in 0 until k - 1)
            pq.poll()

        // k번째 마지막 값을 정답으로 반환
        return pq.poll()
    }
}