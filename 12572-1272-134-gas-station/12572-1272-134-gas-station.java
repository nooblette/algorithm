class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 전체 기름의 양과 전체 이동 비용을 비교하여 출발 지점이 없는 경우 필터링
        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        
        // 전체 주유소를 순회하면서 성립되지 않는 위치를 찾는다.
        int start = 0, fuel = 0;
        for(int i = 0; i < gas.length; i++) {
            // 남은 기름으로 이동할 수 없는 경우
            if(fuel + gas[i] - cost[i] < 0) {
                // 이미 지나친 지점도 출발점이 될 수 없다.
                // 따라서 출발점을 현재 위치의 다음 지점으로 한 칸 밀어낸다.
                start = i + 1;
                fuel = 0;
            } else {
                fuel += gas[i] - cost[i];
            }
        }
        
        return start;
    }
}