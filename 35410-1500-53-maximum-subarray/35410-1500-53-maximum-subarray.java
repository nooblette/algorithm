class Solution {
    public int maxSubArray(int[] nums) {
        
        // 이전 값을 메모이제이션
        for(int i = 1; i < nums.length; i++) {
            // 이전까지의 합이 0보다 크면 누적 합산
            int prev = nums[i - 1];
            nums[i] = nums[i] + (prev > 0 ? prev : 0); 
        }
        
        return Arrays.stream(nums).max().getAsInt();
    }
}