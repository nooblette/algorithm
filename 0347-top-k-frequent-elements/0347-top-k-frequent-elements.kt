class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // 각 엘리먼트의 빈도수를 저장할 해시맵 선언, 엘리먼트 -> 빈도수
        val frequencyMap: MutableMap<Int, Int> = mutableMapOf()
        
        // 각 엘리먼트의 빈도 수를 반복하며 계산하여 저장
        for(n in nums) {
            // 처음 빈도수를 게산하는 경우 디폴트 0, 이미 저장한 엘리먼트라면 빈도수 + 1
            frequencyMap[n] = frequencyMap.getOrDefault(n, 0) + 1
        }
        
        // 빈도순을 기준으로 정렬하는 우선순위 큐 선언
        val pq: PriorityQueue<IntArray> = PriorityQueue{
            a: IntArray, b: IntArray -> b[1] - a[1]
        }
        
        // 우선순위 큐에 각 엘리먼트와 빈도 수 삽입
        for(elem in frequencyMap.keys) {
            pq.add(intArrayOf(elem, frequencyMap[elem]!!))
        }
        
        // 우선순위 큐에서 상위 k개의 원소 출력
        val result = IntArray(k)
        for(i in 0 until k) {
            result[i] = pq.poll()[0]
        }
        
        return result
    }
}