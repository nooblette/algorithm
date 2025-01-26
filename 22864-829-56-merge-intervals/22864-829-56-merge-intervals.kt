class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val merged: MutableList<IntArray> = mutableListOf()
        
        // 첫 번째 값을 기준으로 입력값을 오름차순 정렬
        intervals.sortWith(Comparator {a: IntArray, b: IntArray -> a[0] - b[0]})
        
        // 정렬된 결과 순회
        for(interval in intervals) {
            if(merged.isNotEmpty() && merged[merged.size - 1][1] >= interval[0]) {
                merged[merged.size - 1][1] = max(merged[merged.size - 1][1], interval[1])
            } else {
                // 겹치지 않는 경우 단순 결과 삽입
                merged.add(interval)
            }
        }
        
        // 최종 결과를 반환 타입에 맞춰 변환하여 반환
        return merged.toTypedArray()
    }
}