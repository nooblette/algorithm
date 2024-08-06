class Solution {
    public int arrayPairSum(int[] nums) {
        // nums 배열 정렬
        Arrays.sort(nums);
        
        int sum = 0;
        // 앞에서부터 오름차순으로 반복
        for(int i = 0; i < nums.length; i++) {
            // 짝수번째일때 값의 합 계산
            if(i % 2 == 0) {
                sum += nums[i];
            }
        }
        
        return sum;
    }
}