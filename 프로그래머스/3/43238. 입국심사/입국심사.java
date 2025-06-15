import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        // 주어진 시간 동안 심사할 수 있는 인원을 기준으로 이분 탐색
        long left = 1;
        
        // 가능한 최대 시간(가장 오래걸리는 심사관의 소요 시간 * 모든 인원)으로 초기화
        long right = (long) Arrays.stream(times).max().getAsInt() * n;
        
        // 심사할 수 있는 인원의 초기 중앙 값은 최대값으로 설정
        long mid = right;
        
        long answer = 0;
        while(left <= right) {
            // 각 심사관이 주어진 시간(mid)동안 심사할 수 있는 최대 인원 계산
            long maxImmigrantsInMid = 0;
            for(int time : times) {
                maxImmigrantsInMid += (mid / time);
            }
            
            if(n <= maxImmigrantsInMid) {
                // mid시간 동안 심사가능한 인원이 n보다 큰 경우 -> 최소 시간을 찾아야한다.
                // 따라서 mid를 기준으로 왼쪽에 대해 이분 탐색 반복
                answer = mid;
                right = mid - 1;
            } else {
                // mid시간 동안 심사가능한 인원이 n보다 작은 경우 -> 모든 인원을 심사할 수 없으므로 시간 범위를 늘린다.
                left = mid + 1;
            }
            
            mid = left + (right - left) / 2;
        }
        
        return answer;
    }
}