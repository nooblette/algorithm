import java.util.Arrays

class Solution {
    fun solution(n: Int, times: IntArray): Long {
        // 맨 오른쪽은 (입력 값 중 가장 큰 값 * n)을 최댓값으로 지정
        var right: Long = Arrays.stream(times).max().asInt.toLong() * n
        var left: Long = 1

        var answer: Long = 0
        
        while(left <= right) {
            val mid: Long = left + (right - left) / 2
            
            // 각 심사관이 주어진 mid 시간 동안 심사할 수 있는 최대 인원 계산
            var maxImmigrantsInMid: Long = 0
            for(time in times) {
                maxImmigrantsInMid += (mid / time)
            }
            
            // n을 기준으로 이분탐색하여 n명을 심사할 수 있는 최소시간을 구한다.
            when {
                // 최대 심사가능한 인원이 n보다 크거나 같은 경우, 최소 시간을 구하기 위해 범위를 줄여서 반복한다.
                n <= maxImmigrantsInMid -> {
                    answer = mid
                    right = mid - 1
                }
                // 최대 심사 가능한 인원이 n보다 작은 경우 시간 범위를 늘린다.
                else -> left = mid + 1
            }
            
            // 중앙 값 갱신
        }
        return answer
    }
}