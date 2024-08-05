class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        
        int left, right, sum;
        
        for(int i = 0; i < nums.length-2; i++){
            // 중복된 값 건너뛰기, 정답이 두 번 나올 수 있다.
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            
            // 간격을 좁혀가며 sum 계산
            left = i + 1;
            right = nums.length - 1;
            while(left < right) {
                sum = nums[i] + nums[left] + nums[right];
                
                if(sum < 0) {
                    // sum <0인 경우 left를 한 칸 우측으로 이동
                    left += 1;
                } else if(sum > 0) {
                    // sum >0인 경우 right를 한 칸 좌측으로 이동
                    right -= 1;
                } else {
                    // sum = 0인 경우 reulsts에 원소 추가
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // 중복된 값 건너뛰기, 정답이 두 번 나올수 있다.
                    while(left < right && nums[left] == nums[left+1]) {
                        left += 1;
                    }
                    while(right < left && nums[right] == nums[right-1]) {
                        right -= 1;
                    }
                    
                    //정답을 찾은 경우 투 포인터를 한칸씩 이동
                    left +=1;
                    right -=1;
                }
            }
        }
        
        return results;
    }
}