class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 배열을 탐색하며 만난 요소와 등장한 인덱스를 기록
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            // target을 만들기 위해 필요한 값
            int need = target - nums[i];

            // 이미 등장한적이 있다면 정답 반환
            if(seen.containsKey(need)) {
                return new int[]{seen.get(need), i};
            }

            // 없다면 Map에 기록 후 다음 원소 탐색
            seen.put(nums[i], i);
        }

        // 예외 처리
        return null;
    }
}
