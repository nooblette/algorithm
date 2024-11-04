class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        // 두 배열을 곱한 결과를 반환한다.
        int[] answer = new int[n];

        // 주어진 배열을 왼쪽에서 오른쪽으로 탐색
        // 자기 자신보다 왼쪽에 있는 원소들의 곱을 저장한다.
        int p = 1;
        answer[0] = 1;
        for(int i = 1; i < n; i++) {
            p *= nums[i-1];
            answer[i] = p;   
        }
        
        // 주어진 배열을 오른쪽에서 왼쪽으로 탐색
        // 자기 자신보다 오른쪽에 있는 원소들의 곱을 누적하여 저장한다.
        p = 1;
        for(int i = n-2; i > -1; i--) {
            p *= nums[i+1];
            answer[i] *= p;   
        }
        return answer;
    }
}