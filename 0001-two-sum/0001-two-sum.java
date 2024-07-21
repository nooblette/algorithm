class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        
        // 하나의 for 반복으로 통합
        for(int i = 0; i < nums.length; i++){
            // target에서 num을 뺀 값이 있으면 정답으로 반환
            if(numsMap.containsKey(target - nums[i])) {
                return new int[]{i, numsMap.get(target - nums[i])};
            }
            
            // 정답이 아니라면 다음 비교를 위해 num과 인덱스를
            numsMap.put(nums[i], i);
        }
        
    
        // 항상 정답이 있으므로 null이 반환되는 경우는 없음
        return null;
    }
}