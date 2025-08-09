class Solution {
    public int combinationSum4(int[] nums, int target) {
        // 계산 결과 값을 저장, key : 대상 수, value : key를 만들 수 있는 경우의 수
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(nums, target, memo);
    }

    private int dfs(int[] nums, int target, Map<Integer, Integer> memo) {
        // 합이 음수가 되는 케이스는 만들 수 없다. (예외 처리))
        if(target < 0) {
            return 0;
        }

        // 0을 만드는 조합의 개수는 아무것도 선정하지 않는 경우 1가지가 존재
        if(target == 0) {
            return 1;
        }

        // 이미 계산한 값이면 중복 계산하지 않고 반환
        if(memo.containsKey(target)) {
            return memo.get(target);
        }

        int result = 0;
        for(int num : nums) {
            // 기존에 target을 만들 수 있는 경우의 수에서 마지막 원소로 num을 붙이는 경우의 수를 누적한다.
            result += dfs(nums, target - num, memo);
        }

        memo.put(target, result);
        return result;
    }
}
