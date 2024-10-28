class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        
        // 탐색 전 정렬 수행 - target과 일치하는 원소 탐색을 효율적으로 하기 위함
        Arrays.sort(nums);
        
        Set<List<Integer>> answer = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                // 투 포인터 left, rigt 선언
                int left = j + 1;
                int right = n - 1;
                
                // 두 포인터가 서로 엇갈리기 전까지
                while(left < right) {
                    // 4개의 합이 target 보다 작다면 left를 우측(원소 합이 증가하는 방향)으로 이동한다.
                    if(target > (long) nums[i] + nums[j] + nums[left] + nums[right]) {
                        left += 1;
                    } else if (target < (long) nums[i] + nums[j] + nums[left] + nums[right]) {
                        // 4개의 합이 target 보다 크다면 right를 좌측(원소 합이 감소하는 방향)으로 이동한다.
                        right -= 1;
                    } else {
                        // 4개의 합이 target과 같은 경우(정답을 찾은 경우) 정답 배열에 추가한다.
                        answer.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        
                        // 다시 탐색 진행
                        left += 1;
                        right -= 1;
                    }
                }
            }
        }
        
        return new ArrayList<>(answer);
    }
}