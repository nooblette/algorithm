class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                // 동일한 인덱스는 건너뛴다.
                if(i == j){
                    continue;
                }

                // 정답을 찾은 경우
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        // 예외 처리
        return null;
    }
}
