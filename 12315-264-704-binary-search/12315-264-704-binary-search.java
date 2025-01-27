class Solution {
    public int binarySearch(int[] nums, int target, int left, int right) {
        // 왼쪽 포인터가 오른쪽 포인터보다 크다면 target에 해당하는 값이 없으므로 -1을 반환
        if(left > right) return -1;
        
        // 중앙 값 계산
        int mid = left + (right - left) / 2;
        
        // 만약 target이 중앙 값보다 작다면 왼쪽 범위 탐색
        if(target < nums[mid]) {
            return binarySearch(nums, target, left, mid - 1);
        } else if (target > nums[mid]) {
            // 만약 target이 중앙 값보다 크다면 오른쪽 범위 탐색
            return binarySearch(nums, target, mid + 1, right);
        } else {
            // 정답을 찾은 경우 결과 반환
            return mid;
        }
    }
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }
}