class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 정렬
        Arrays.sort(nums);

        // 중복 제거를 위해 Set<>으로 선언한다.
        Set<List<Integer>> answer = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            // left와 right를 이동하며 i + left + right = 0이 되는 left와 right를 찾는다.
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] > 0) {
                    // 총 합이 감소하는 방향으로 이동한다.
                    right -= 1;
                } else if(nums[i] + nums[left] + nums[right] < 0) {
                    // 총 합이 증가하는 방향으로 이동한다.
                    left += 1;
                } else {
                    // 정답을 찾은 경우
                    answer.add(List.of(nums[i], nums[left], nums[right]));

                    // 위 과정 반복
                    left += 1;
                }
            }
        }

        return new ArrayList<>(answer);
    }
}
