class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        
        // 키와 값을 바꿔서 맵으로 저장
        for(int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        
        // target에서 첫 번째 수를 뺀 결과를 키로 조회, 현재 인덱스가 아닌 경루 정답으로 처리
        for(int i = 0; i < nums.length; i++) {
            if(numsMap.containsKey(target - nums[i]) && i != numsMap.get(target - nums[i])) {
                return new int[]{i, numsMap.get(target - nums[i])};
            }
        }
        
        // 항상 정답이 있으므로 null이 반환되는 경우는 없음
        return null;
    }
}