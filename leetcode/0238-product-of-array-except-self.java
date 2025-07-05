class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // 좌측에서 우측, 우측에서 좌측으로 이동하며 원소들의 누적 곱을 저장하는 배열 선언
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];

        // left, right 배열 초기화
        left[0] = 1;
        for(int i = 1; i <= n; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        right[n] = 1;
        for(int i = n-1; i >= 0; i--) {
            right[i] = right[i+1] * nums[i];
        }

        // 자기 자신(i)을 제외하고 좌측(left[0])에서 우측(left[i-1])의 누적 곱과 우측(right[n])에서 좌측(right[i+1])의 누적곱의 곱을 구한다.
        int[] answer = new int[n];
        for(int i = 1; i <= n; i++) {
            answer[i-1] = left[i-1] * right[i];
        }
        return answer;
    }
}
