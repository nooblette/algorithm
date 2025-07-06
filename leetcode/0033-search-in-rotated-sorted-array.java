class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            // 정답을 찾은 경우 탐색 종료
            if(nums[mid] == target) {
                return mid;
            }

            // 이분 탐색이 가능한 정렬된 구간을 찾는다.
            // 왼쪽 구간이 정렬된 경우 (left와 mid가 동일할 수 있으므로 <=으로 비교한다.)
            if(nums[left] <= nums[mid]) {
                // 정렬된 구간에 target이 포함되는 경우
                if(nums[left] <= target && target <= nums[mid]) {
                    // 이 구간에 대해 이분 탐색한다.
                    right = mid;
                } else {
                    // 정렬된 구간에 target이 포함되지 않은 경우
                    // 오른쪽 범위에 대해 다시 정렬된 구간을 찾는 과정을 반복한다.
                    left = mid + 1;
                }
            } else {
                // 오른쪽 구간이 정렬된 경우
                // 정렬된 구간에 target이 포함되는 경우
                if(nums[mid] <= target && target <= nums[right]) {
                    // 이 구간에 대해 이분 탐색한다.
                    left = mid;
                } else {
                    // 정렬된 구간에 target이 포함되지 않은 경우
                    // 왼쪽 범위에 대해 다시 정렬된 구간을 찾는 과정을 반복한다.
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
