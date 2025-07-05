class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] answer = new int[n];

        int p = 1;
        answer[0] = 1;

        // 주어진 배열을 좌측에서 우측으로 탐색
        // 자기 자식보다 좌측에 있는 원소들의 곱을 저장한다.
        for(int i = 1; i < n; i++) {
            p *= nums[i-1];
            answer[i] = p;
        }

        // 주어진 배열을 우측에서 좌측으로 탐색
        // 자기 자식보다 우측에 있는 원소들의 곱을 저장한다.
        p = 1;
        for(int i = n-2; i >= 0; i--) {
            p *= nums[i+1];
            answer[i] *= p;
        }

        return answer;
    }
}
