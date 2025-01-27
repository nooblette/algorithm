class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;

            // 오른쪽 배열의 시작 값 찾기(오른쪽 배열의 시작 값이 항상 nums 배열의 최소 값이 된다.)
            if(nums[mid] < nums[right]) {
                // mid의 값이 right보다 작다면 오른쪽 배열의 시작 값은 mid보다 왼쪽에 위치한다.
                // right를 mid로 갱신한다.
                right = mid;
            } else {
                // mid의 값이 left보다 크거나 같다면 오른쪽 배열의 시작 값은 mid보다 오른쪽에 위치한다.
              // left를 mid로 갱신한다.
              left = mid + 1;
            }
        }
               
        // 회전하기 전 배열의 최소값이 nums 배열에서 위치한 인덱스를 찾는다. 
        int minimumIndex = left;

        left = 0;
        right = nums.length - 1;

        // 왼쪽 포인터가 오른쪽 포인터보다 작거나 같다면 계속 탐색
        while(left <= right) {
            // 중앙 인덱스 계산
            // mid는 nums 배열과 아무런 연관이 없다. 단지 현재 이분 탐색 중인 범위의 중앙 값에 해당한다.
            int mid = left + (right - left) / 2;

            // 회전하기 전 배열의 중앙 값이 nums 배열에 위치한 인덱스 계산
            int midPivot = (mid + minimumIndex) % nums.length;

            // target이 midPivot의 값보다 작다면 이 값은 중앙보다 왼쪽에 위치한다.
            if(nums[midPivot] > target) {
                // 왼쪽 범위를 탐색한다.
                right = mid - 1;
            } else if(nums[midPivot] < target) {
                // target이 midPivot의 값보다 크다면 이 값은 중앙보다 오른쪽에 위치한다.
                // 오른쪽 범위를 탐색한다.
                left = mid + 1;
            } else {
                // target이 midPivot과 같다면 정답을 찾았으니 midPivot을 반환한다.
                return midPivot;
            }
        }
               
        return -1;
    }
}