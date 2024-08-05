class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        var left: Int
        var right: Int
        var sum: Int
        val results: MutableList<List<Int>> = mutableListOf()
        
        Arrays.sort(nums)
        
        for(i in 0 until nums.size - 2) {
            // 중복된 값 건너뛰기, 정답이 두 번 나올 수 있다.
            if(i > 0 && nums[i] == nums[i-1])
                continue
            
            // 간격을 좁혀가며 sum 계산
            left = i + 1
            right = nums.size - 1
            while(left < right) {
                sum = nums[i] + nums[left] + nums[right]
                
                if(sum < 0) {
                    left += 1
                } else if(sum > 0) {
                    right -= 1
                } else {
                    // 합이 0인 경우 정답 처리
                    results.add(listOf(nums[i], nums[left], nums[right]))
                    
                    // 중복된 값 건너뛰기, 정답이 두 번 나올 수 있다.
                    while(left < right && nums[left] == nums[left + 1]) {
                        left += 1
                    }
                    while(left < right && nums[right] == nums[right - 1]) {
                        right -= 1
                    }
                    
                    // 정답이 나왔으므로 투 포인터를 한 칸씩 이동
                    // 값이 0인 상황이므로 모두 한칸씩 이동해야한다.
                    left += 1
                    right -= 1
                }
            }
        }
        
        return results
    }
}