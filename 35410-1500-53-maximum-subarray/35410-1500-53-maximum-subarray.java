class Solution {
    public int maxSubArray(int[] nums) {
        // 매 순간 최적해를 저장
        int currentSum = 0;
        
        // 매 순간 최적해를 누적
        int bestSum = Integer.MIN_VALUE;
        
        for(int num : nums) {
            // 매 순간 최적해 계산
            currentSum = Math.max(num, currentSum + num);
            
            // 최댓값 갱신
            bestSum = Math.max(bestSum, currentSum);
        }
        
        
        return bestSum;
    }
}