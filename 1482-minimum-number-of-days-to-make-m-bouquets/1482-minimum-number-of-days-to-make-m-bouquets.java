class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // 피는데 가장 오래 걸리는 일자와 적게 걸리는 일자 조회
        int maxDay = 0;
        int minDay = Integer.MAX_VALUE;
        for(int day : bloomDay) {
            maxDay = Math.max(maxDay, day);
            minDay = Math.min(minDay, day);
        }
        
        // 부케를 만들 수 없는 경우 -1을 반환한다.
        if(bloomDay.length < m * k) return -1;
        
        int answer = Integer.MAX_VALUE;
	    while(minDay <= maxDay) {
		    // 주어진 날짜 범위에 대해 이분탐색 진행
		    int mid = minDay + (maxDay - minDay) / 2;
            
            // 해당 일자에 부케를 만들 수 있는지 확인
            int count = k;
            
            // 만든 부케 개수
            int bouquet = 0;
            
            for(int day : bloomDay) {
                // 꽃이 필 수 있는 경우
                if(day <= mid) {
                    count--;
                    
                    // k개의 연속된 꽃이 모두 핀 경우
                    if(count == 0) {
                        count = k;
                        bouquet += 1;
                    }
                } else {
                    // 꽃이 필 수 없는 경우 연속이 끊겼으므로 k로 다시 초기화 한다.
                    count = k;
                }
            }
            
            // 부케를 만든 경우, 더 적은 날짜에 대해 탐색을 다시 진행한다.
            if(bouquet >= m) {
                maxDay = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                // 부케를 만들 수 없는 경우, 더 큰 날짜에 대해 탐색을 다시 진행한다.
                minDay = mid + 1;
            }
        }
        
        // 최대 일자보다 커진 경우 -1을 반환한다.
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}