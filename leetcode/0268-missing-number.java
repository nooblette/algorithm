class Solution {
    public int missingNumber(int[] nums) {
        // 0부터 n까지의 합 - 주어진 배열의 원소들의 합
        int n = nums.length;
        return (n * (n + 1) / 2) - Arrays.stream(nums).sum();
    }
}
