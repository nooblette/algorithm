class Solution {
    public int maxSubArray(int[] nums) {
        // 첫 번째 값을 초기값으로 리스트 선언
        List<Integer> sums = new ArrayList<>(List.of(nums[0]));
        
        // 이전 값을 메모이제이션
        for(int i = 1; i < nums.length; i++) {
            // 이전까지의 합이 0보다 크면 누적 합산
            int prev = sums.get(i - 1);
            sums.add(nums[i] + (prev > 0 ? prev : 0));
        }
        
        return Collections.max(sums);
    }
}