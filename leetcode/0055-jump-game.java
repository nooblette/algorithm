class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for(int i = 0; i < nums.length; i++) {
            // 이동가능한 최대 거리가 특정 인덱스를 넘지 못한다면 마지막 인덱스에도 도달할 수 없다.
            if(i > maxReach) {
                return false;
            }

            // 매 순간마다 최대 거리만큼 이동
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        // 마지막 인덱스에 도달하거나 길이를 초과한 경우 마지막 지점에 도달 가능
        return maxReach >= nums.length - 1;
    }
}
