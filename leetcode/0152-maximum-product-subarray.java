class Solution {
    public int maxProduct(int[] nums) {
        // 최대/최소값 추적
        int maxValue = nums[0];
        int minValue = nums[0];

        int answer = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int num = nums[i];
           
            // 현재 원소가 음수인 경우 최대값과 최소값을 서로 변경한다.
            if(num < 0) {
                int temp = maxValue;
                maxValue = minValue;
                minValue = temp;
            }

            // 기존 누적 곱에 현재 원소를 곱하는 경우와 현재 원소만을 취하는 경우 중 더 큰 값을 취한다.
            maxValue = Math.max(num, maxValue * num);
            minValue = Math.min(num, minValue * num);

            // 최적해 갱신
            answer = Math.max(answer, maxValue);
        }

        return answer;
    }
}
