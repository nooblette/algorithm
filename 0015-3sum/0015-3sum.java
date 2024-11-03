class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        
        // 투 포인터를 사용하기 위해 주어진 배열을 정렬
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            // 이전과 동일한 원소가 등장하는 경우 이미 체크한 조합이므로 넘어간다.
            if(i > 0 && nums[i-1] == nums[i]) continue;
            
            //  i + 1을 가리키는 포인터
            int left = i + 1;
            
            // 마지막 원소를 가리키는 포인터
            int right = nums.length - 1;
            
            while(left < right) {
                // 3개의 원소의 합이 0보다 크다면 right를 한 칸 왼쪽으로 이동한다. (합이 감소하는 방향)
                if(nums[i] + nums[left] + nums[right] > 0) {
                    // 중복된 원소 조합에 대한 탐색을 방지하기 위해 다른 숫자가 등장할때까지 right를 왼쪽으로 계속 이동한다.
                    while(left < right && nums[right - 1] == nums[right]) {
                        right -= 1;
                    }
                    
                    right -= 1;
                } else if(nums[i] + nums[left] + nums[right] < 0) {
                    // 중복된 원소 조합에 대한 탐색을 방지하기 위해 다른 숫자가 등장할때까지 right를 왼쪽으로 계속 이동한다.
                    while(left < right && nums[left + 1] == nums[left]) {
                        left += 1;
                    }
                    
                    // 합이 0보다 작다면 left를 한 칸 오른쪽으로 이동한다. (합이 증가하는 방향)
                    left += 1;
                } else {
                    // 합이 0이라면 결과 목록에 추가한다.
                    answer.add(List.of(nums[i], nums[left], nums[right]));
                    
                    // 중복된 원소 조합에 대한 탐색을 방지하기 위해 다른 숫자가 등장할때까지 right를 왼쪽으로 계속 이동한다.
                    while(left < right && nums[right - 1] == nums[right]) {
                        right -= 1;
                    }
                    
                    // 중복된 원소 조합에 대한 탐색을 방지하기 위해 다른 숫자가 등장할때까지 right를 왼쪽으로 계속 이동한다.
                    while(left < right && nums[left + 1] == nums[left]) {
                        left += 1;
                    }
                    
                    // 두 포인터는 각각 좌우로 이동한다. (다음 인덱스에 대해 탐색 진행)
                    right -= 1;
                    left += 1;
                }
            }
        }
        
        return answer;
    }
}