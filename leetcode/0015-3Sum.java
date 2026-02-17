class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 투 포인터 탐색을 위해 주어진 배열을 정렬
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        // 고정 인덱스 정의
        for(int i = 0; i < nums.length - 2; i++) {
            // 고정 인덱스 중복 처리
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 3개 포인터가 가리키는 값의 합이 0이 되는 방향으로 투 포인터 탐색
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // 총 합이 0보다 크다면 총 합이 감소하는 방향으로 탐색
                if(sum > 0) {
                    right--;
                } else if(sum < 0){
                    // 총 합이 0보다 작다면 총 합이 증가하는 방향으로 탐색
                    left++;
                } else {
                    // 총 합이 0이라면 정답 배열에 추가하고 다음 범위 탐색
                    result.add(List.of(nums[i], nums[left], nums[right]));

                    // right 포인터 중복 처리
                    while(left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // left 포인터 중복 처리
                    while(left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    
                    right--;
                    left++;
                }
            }
        }

        return result;
    }
}
