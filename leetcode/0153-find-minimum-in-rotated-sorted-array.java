class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right) {
            int mid = left + (right - left) / 2;

            // 중앙 값이 좌우 배열 중 어느 배열에 속하는지 판단
            if(nums[mid] > nums[right]) {
                // 중앙값이 우측 끝 값보다 큰 경우, 좌측 배열에 속해야 정렬이 유지된다.
                // 이 경우 우측 배열에 최소값이 있으므로 우측 배열에 대해 탐색을 반복한다.
                left = mid + 1;
            } else {
                // 중앙값이 우측 끝 값보다 작은 경우, 우측 배열에 속해야 정렬이 유지된다.
                // 이 경우 좌측 배열에 최소값이 있으므로 좌측 배열에 대해 탐색을 반복한다.

                // mid가 우측 배열에 속하지만 최소값인 경우도 감안해야하므로 탐색 범위에 포함해야한다.
                // 따라서 right를 mid로 갱신한다.
                right = mid;
            }
        }

        return nums[left];
    }
}
