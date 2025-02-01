import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        
        // 맨 오른쪽은 (입력 값 중 가장 큰 값 * n)을 최댓값으로 지정
        long right = (long) Arrays.stream(times).max().getAsInt() * n;
        
        // 초기 중앙 값은 최대값으로 설정
        long mid = right;
        
        long answer = 0;
        while(left <= right) {
            // 각 심사관이 주어진 mid 시간 동안 심사할 수 있는 최대 인원 계산
            long maxImmigrantsInMid = 0;
            for(int time : times) {
                maxImmigrantsInMid += (mid / time);
            }
            
            // n을 기준으로 이분탐색하여 n명을 심사할 수 있는 최소시간을 구한다.
            if(n <= maxImmigrantsInMid) {
                // 최대 심사가능한 인원이 n보다 크거나 같은 경우, 최소 시간을 구하기 위해 범위를 줄여서 반복한다.
                answer = mid;
                right = mid - 1;
            } else {
                // 최대 심사 가능한 인원이 n보다 작은 경우 시간 범위를 늘린다.
                left = mid + 1;
            }
            
            // 중앙 값 갱신
            mid = left + (right - left) / 2;
        }
        return answer;
    }
}