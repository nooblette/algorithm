class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        
        while(left < right) {
            val mid = left + (right - left) / 2
            
            // 오른쪽 배열의 시작 값 찾기(오른쪽 배열의 시작 값이 항상 nums 배열의 최소 값이 된다.)
            when {
                // mid의 값이 right보다 작다면 오른쪽 배열의 시작 값은 mid보다 왼쪽에 위치한다.
                // right를 mid로 갱신한다.
                nums[mid] < nums[right] -> right = mid
                // mid의 값이 left보다 크거나 같다면 오른쪽 배열의 시작 값은 mid보다 오른쪽에 위치한다.

                // left를 mid + 1로 갱신한다.
                else -> left = mid + 1
            }
        }
        
        // 회전하기 전 배열의 최소값이 nums 배열에서 위치한 인덱스를 찾는다. 
        val minimumValue = left
        
        left = 0 
        right = nums.size - 1
        
        while(left <= right) {
            // 중앙 인덱스 계산
            // mid는 nums 배열과 아무런 연관이 없다. 단지 현재 이분 탐색 중인 범위의 중앙 값에 해당한다.
            val mid = left + (right - left) / 2
            
            // 회전하기 전 배열의 중앙 값이 nums 배열에 위치한 인덱스 계산
            val midPivot = (mid + minimumValue) % nums.size
            
            when {
                // target이 midPivot의 값보다 작다면 이 값은 중앙보다 왼쪽에 위치한다.
                target < nums[midPivot] -> right = mid - 1
                // target이 midPivot의 값보다 크다면 이 값은 중앙보다 오른쪽에 위치한다.
                target > nums[midPivot] -> left = mid + 1
                // target이 midPivot과 같다면 정답을 찾았으니 midPivot을 반환한다.
                else -> return midPivot
            }
        }
        
        // 모두 탐색했으나 정답을 찾지 못한 경우 -1을 반환한다.
        return -1
    }
}