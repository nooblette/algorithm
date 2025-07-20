class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int result = n;
        for(int i = 0; i < n; i++) {
            // 0부터 n까지 모든 수에 대해 XOR 연산을 취한다.
            // 그 결과에 대해 각 원소별로 대해 XOR 연산을 취한다.
            result ^= i ^ nums[i];
        }

        // 누락되지 않은 수는 2번 등작하여 XOR 연산에 의해 상쇄되고, 누락된 수만 1번 등장하여 남게된다.
        return result;
    }
}
