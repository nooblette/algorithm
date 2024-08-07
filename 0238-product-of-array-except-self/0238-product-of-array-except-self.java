class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        int p = 1;
        for(int i = 0; i < nums.length; i++) {
            result[i] = p;
            
            // p는 0번 부터 i-1번까지의 곱셈 결과를 누적하여 갖고한다.
            p *= nums[i];
        }
        
        // 오른쪽 곱셈, 왼쪽 곱셈 결과에 차례대로 곱한다.
        p = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            result[i] *= p;
            
            // p는 n번 부터 i+1번까지의 곱셈 결과를 누적하여 갖고있다.
            p *= nums[i];
        }
        
        return result;
    }
}