class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        // 왼쪽에서 오른쪽으로 이동하면서 원소들의 곱한 결과 값을 저장
        int[] left = new int[n];
        left[0] = 1;
        for(int i = 1; i < n; i++) {
            left[i] = left[i-1] * nums[i-1]; 
        }
        
        // 오른쪽에서 왼쪽으로 이동하면서 원소들의 곱한 결과 값을 저장
        int[] right = new int[n];
        right[n-1] = 1;
        for(int i = n-2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        
        // 두 배열을 곱한 결과를 반환한다.
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            answer[i] = left[i] * right[i];
        }
        return answer;
    }
}