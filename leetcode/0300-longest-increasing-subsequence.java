class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int answer = 1;
        
        // 인덱스 별로 최장 부분 배열 길이 저장
        int[] dp = new int[n];

        // 초기화 - 모든 위치에서 최소 길이는 1
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                // 이전 원소 중 현재 원소보다 작은 값부터 1 증가
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
