class Solution {
    public int maxSubArray(int[] nums) {
        int sumOfSubArray = 0;

        // 음수 오버플로우를 방지하기 위해 Integer.MIN_VALUE가 아닌 첫번째 값으로 초기화한다.
        int answer = nums[0];

        // 누적합 계산
        for(int num : nums) {
            // 현재까지 구한 값에 누적하는 경우와 새로 시작하는 경우 중 더 큰 값을 취한다.
            sumOfSubArray = Math.max(sumOfSubArray + num, num);
            answer = Math.max(answer, sumOfSubArray);
        }

        return answer;
    }
}
