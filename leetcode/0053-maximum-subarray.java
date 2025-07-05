class Solution {
    public int maxSubArray(int[] nums) {
        int sumOfSubArray = Integer.MIN_VALUE;
        int answer = Integer.MIN_VALUE;

        // 누적합 계산
        for(int num : nums) {
            // 현재까지의 누적합이 음수인 경우 새로 시작한다.
            if(sumOfSubArray < 0) {
                sumOfSubArray = num;
            } else {
                // 현재까지의 누적합이 양수인 경우 다음 계산에 사용한다.
                sumOfSubArray += num;
            }
            
            answer = Math.max(answer, sumOfSubArray);
        }

        return answer;
    }
}
