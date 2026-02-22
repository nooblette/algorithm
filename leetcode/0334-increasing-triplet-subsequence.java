class Solution {
    public boolean increasingTriplet(int[] nums) {
        // 증가하는 Subsequence(nums[i] < nums[j] < nums[k])를 만족하는 두 개의 인덱스(i, j)를 기록
        int i = 0;
        int j = -1;

        for(int k = 1; k < nums.length; k++) {
            // j가 유효(nums[i] < nums[j])한 경우 초기화
            if(j == -1 && nums[i] < nums[k]) {
                j = k;
                continue;
            }

            // j가 유효하면서 nums[j] < nums[k]를 만족하는 k가 나온다면 Tripet을 완성하므로 탐색을 종료한다.
            if(j != -1 && nums[j] < nums[k]) {
                return true;
            } else if(j != -1 && nums[i] < nums[k] && nums[k] < nums[j]) {
                // j가 유효하면서 nums[i]보다 크고 nums[j]보다 작은 nums[k]가 등장한다면 nums[i] < nums[j]를 유지하기 위해 j를 갱신한다.
                j = k;
            } else if(nums[i] > nums[k]) {
                // nums[i]보다 작은 nums[k]가 등장한다면 i를 갱신한다.
                // 하지만 j는 갱신 이전 i에 대해 nums[i] < nums[j]를 만족하는 유효한 포인터일 수 있다.
                // 따라서 다음 nums[k]에 대해 increasingTriplet을 만족할 수 있으므로 j를 초기화하면 안된다. (이전 탐색 결과를 기록하고 있어야한다.)
                i = k;
            }
        }

        // 도중에 increasingTriplet을 찾지 못했다면 false 반환
        return false;
    }
}
