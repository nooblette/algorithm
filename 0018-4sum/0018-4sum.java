class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 중복 방지를 위해 Set으로 선언
        Set<List<Integer>> answer = new HashSet<>();
        
        // 주어진 배열을 정렬
        Arrays.sort(nums);
        
        // i번째 인덱스와 i+1번째 인덱스는 고정
        for(int i = 0; i < nums.length - 3; i++) {
            for(int j = i + 1; j < nums.length - 2; j++) {
                // 이 후 원소에 대해 포인터를 옮겨가며 탐색
                int left = j + 1;
                int right = nums.length - 1;
                
                while(left < right && right < nums.length) {
                    // 4개의 원소의 합이 target 보다 작은 경우
                    if((long) nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        // left를 한 칸 우측으로 이동한다 (합이 증가하는 방향)
                        left += 1;
                    } else if((long) nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        // 4개의 원소의 합이 target 보다 큰 경우
                        // right를 한 칸 좌측으로 이동한다 (합이 감소하는 방향)
                        right -= 1;
                    } else {
                        // 4개의 원소의 합이 target이 되는 경우
                        answer.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        
                        // left는 우측으로, right는 좌측으로 이동 (두 포인터를 모두 이동)
                        left += 1;
                        right -= 1;
                    } 
                }
                
            }
        }
        
        return new ArrayList<>(answer);
    }
}