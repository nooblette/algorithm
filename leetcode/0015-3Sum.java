class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 정렬
        Arrays.sort(nums);

        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            // 중복된 i 값 건너뛰기
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            // left와 right를 이동하며 i + left + right = 0이 되는 left와 right를 찾는다.
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] > 0) {
                    // 총 합이 감소하는 방향으로 이동한다.
                    right--;
                } else if(nums[i] + nums[left] + nums[right] < 0) {
                    // 총 합이 증가하는 방향으로 이동한다.
                    left++;
                } else {
                    // 정답을 찾은 경우
                    answer.add(List.of(nums[i], nums[left], nums[right]));

                    // 동일한 값인 동안 left와 right을 이동하여 중복을 방지한다.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--; 
                    }

                    // left와 right를 함께 이동하여 탐색 범위를 줄인다.
                    left++;
                    right--;
                }
            }
        }

        return new ArrayList<>(answer);
    }
}
